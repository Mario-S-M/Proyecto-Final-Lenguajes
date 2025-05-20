package com.practica1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {

    private final Map<String, Object> variables = new HashMap<>();
    private final Map<String, String> variableTypes = new HashMap<>();
    private final List<Statement> statements = new ArrayList<>();

    public List<Statement> getStatements() {
        return statements;
    }

    // Statement types
    public static interface Statement {
        String execute(); // Añadir este método
    }

    public static class Declaration implements Statement {
        public String type;
        public String varName;
        public Object value;

        public Declaration(String type, String varName, Object value) {
            this.type = type;
            this.varName = varName;
            this.value = value;
        }

        @Override
        public String execute() {
            return "Declaración: " + type + " " + varName + " = " + value;
        }
    }

    public static class Assignment implements Statement {
        public String varName;
        public Object expression;

        public Assignment(String varName, Object expression) {
            this.varName = varName;
            this.expression = expression;
        }

        @Override
        public String execute() {
            return "Asignación: " + varName + " = " + expression;
        }
    }

    public static class Print implements Statement {
        public Object expression;

        public Print(Object expression) {
            this.expression = expression;
        }

        @Override
        public String execute() {
            return "Impresión: " + expression;
        }
    }

    public static class IfStmt implements Statement {
        public Object condition;
        public List<Statement> thenBlock;
        public List<ElseIfStmt> elseIfs;
        public List<Statement> elseBlock;

        public IfStmt(Object condition, List<Statement> thenBlock, List<ElseIfStmt> elseIfs,
                List<Statement> elseBlock) {
            this.condition = condition;
            this.thenBlock = thenBlock;
            this.elseIfs = elseIfs;
            this.elseBlock = elseBlock;
        }

        @Override
        public String execute() {
            StringBuilder result = new StringBuilder();
            result.append("If (").append(condition).append(") {\n");
            
            for (Statement stmt : thenBlock) {
                result.append("  ").append(stmt.execute()).append("\n");
            }
            
            for (ElseIfStmt elseif : elseIfs) {
                result.append("} else if (").append(elseif.condition).append(") {\n");
                for (Statement stmt : elseif.block) {
                    result.append("  ").append(stmt.execute()).append("\n");
                }
            }
            
            if (!elseBlock.isEmpty()) {
                result.append("} else {\n");
                for (Statement stmt : elseBlock) {
                    result.append("  ").append(stmt.execute()).append("\n");
                }
            }
            
            result.append("}");
            return result.toString();
        }
    }

    public static class ElseIfStmt {
        public Object condition;
        public List<Statement> block;

        public ElseIfStmt(Object condition, List<Statement> block) {
            this.condition = condition;
            this.block = block;
        }
    }

    public static class ForLoop implements Statement {
        public Statement initialization;
        public Object condition;
        public Statement update;
        public List<Statement> body;

        public ForLoop(Statement initialization, Object condition, Statement update, List<Statement> body) {
            this.initialization = initialization;
            this.condition = condition;
            this.update = update;
            this.body = body;
        }

        @Override
        public String execute() {
            StringBuilder result = new StringBuilder();
            result.append("For (");
            
            if (initialization != null) {
                result.append(initialization.execute());
            }
            result.append("; ");
            
            if (condition != null) {
                result.append(condition);
            }
            result.append("; ");
            
            if (update != null) {
                result.append(update.execute());
            }
            result.append(") {\n");
            
            for (Statement stmt : body) {
                result.append("  ").append(stmt.execute()).append("\n");
            }
            
            result.append("}");
            return result.toString();
        }
    }

    public static class Increment implements Statement {
        public String varName;
        public String operator;

        public Increment(String varName, String operator) {
            this.varName = varName;
            this.operator = operator;
        }

        @Override
        public String execute() {
            return "Incremento: " + varName + operator;
        }
    }

    @Override
    public Object visitAlmaPrograma(LanguageParser.AlmaProgramaContext ctx) {
        for (LanguageParser.AlmaDeclaracionContext decl : ctx.almaDeclaracion()) {
            visit(decl);
        }
        for (LanguageParser.AlmaInstruccionContext instr : ctx.almaInstruccion()) {
            visit(instr);
        }
        return null;
    }

    @Override
    public Object visitAlmaDeclaracion(LanguageParser.AlmaDeclaracionContext ctx) {
        String type = ctx.almaTipo().getText().replace("AlmaLilia.", "");
        String varName = ctx.ALMA_ID().getText();
        variableTypes.put(varName, type);

        Object value = null;
        if (ctx.almaExpresion() != null) {
            value = visit(ctx.almaExpresion());
            value = convertToType(value, type);
            variables.put(varName, value);
            System.out.println("[DECLARACIÓN] " + type + " " + varName + " = " + value);
        } else {
            Object defaultValue = getDefaultValue(type);
            variables.put(varName, defaultValue);
            System.out.println("[DECLARACIÓN] " + type + " " + varName + " (valor por defecto: " + defaultValue + ")");
        }
        statements.add(new Declaration(type, varName, value));
        return null;
    }

    @Override
    public Object visitAlmaSi(LanguageParser.AlmaSiContext ctx) {
        Object condition = visit(ctx.almaCondicion(0));
        List<Statement> thenBlock = new ArrayList<>();

        for (LanguageParser.AlmaInstruccionContext instr : ctx.almaBloque(0).almaInstruccion()) {
            Object result = visit(instr);
            if (result instanceof Statement) {
                thenBlock.add((Statement) result);
            }
        }

        List<ElseIfStmt> elseIfs = new ArrayList<>();
        for (int i = 1; i < ctx.almaCondicion().size(); i++) {
            Object elseifCond = visit(ctx.almaCondicion(i));
            List<Statement> elseifBlock = new ArrayList<>();
            for (LanguageParser.AlmaInstruccionContext instr : ctx.almaBloque(i).almaInstruccion()) {
                Object result = visit(instr);
                if (result instanceof Statement) {
                    elseifBlock.add((Statement) result);
                }
            }
            elseIfs.add(new ElseIfStmt(elseifCond, elseifBlock));
        }

        List<Statement> elseBlock = new ArrayList<>();
        if (ctx.almaSino() != null) {
            for (LanguageParser.AlmaInstruccionContext instr : ctx.almaSino().almaBloque().almaInstruccion()) {
                Object result = visit(instr);
                if (result instanceof Statement) {
                    elseBlock.add((Statement) result);
                }
            }
        }

        IfStmt ifStmt = new IfStmt(condition, thenBlock, elseIfs, elseBlock);
        statements.add(ifStmt);
        return ifStmt;
    }

    @Override
    public Object visitAlmaAsignar(LanguageParser.AlmaAsignarContext ctx) {
        String varName = ctx.ALMA_ID().getText();
        Object value = visit(ctx.almaExpresion());

        if (variableTypes.containsKey(varName)) {
            String expectedType = variableTypes.get(varName);
            value = convertToType(value, expectedType);
            System.out.println("[ASIGNACIÓN] " + varName + " (" + expectedType + ") = " + value);
        } else {
            String inferredType = inferType(value);
            variableTypes.put(varName, inferredType);
            System.out.println("[ASIGNACIÓN IMPLÍCITA] " + varName + " (" + inferredType + ") = " + value);
        }

        variables.put(varName, value);
        statements.add(new Assignment(varName, value));
        return value;
    }

    @Override
    public Object visitAlmaIncremento(LanguageParser.AlmaIncrementoContext ctx) {
        if (ctx.almaIncrementoSimple() != null) {
            return visit(ctx.almaIncrementoSimple());
        } else {
            return visit(ctx.almaAsignacionCompuesta());
        }
    }

    @Override
    public Object visitAlmaIncrementoSimple(LanguageParser.AlmaIncrementoSimpleContext ctx) {
        String varName = ctx.ALMA_ID().getText();
        Object currentValue = variables.get(varName);
        String op = ctx.getChild(1).getText();

        Object newValue = op.equals("++") ? add(currentValue, 1) : subtract(currentValue, 1);
        variables.put(varName, newValue);
        System.out.println("[INCREMENTO/DECREMENTO] " + varName + op + " => " + newValue);
        statements.add(new Increment(varName, op));
        return newValue;
    }

    @Override
    public Object visitAlmaAsignacionCompuesta(LanguageParser.AlmaAsignacionCompuestaContext ctx) {
        String varName = ctx.ALMA_ID(0).getText();
        Object currentValue = variables.get(varName);
        String op = ctx.getChild(3).getText();
        Object increment = ctx.ALMA_NUM() != null ? Integer.valueOf(ctx.ALMA_NUM().getText())
                : ctx.ALMA_DECIMAL() != null ? Float.valueOf(ctx.ALMA_DECIMAL().getText()) : 0;

        Object newValue;
        switch (op) {
            case "+":
                newValue = add(currentValue, increment);
                break;
            case "-":
                newValue = subtract(currentValue, increment);
                break;
            case "*":
                newValue = multiply(currentValue, increment);
                break;
            case "/":
                newValue = divide(currentValue, increment);
                break;
            default:
                throw new RuntimeException("Operador no soportado: " + op);
        }

        variables.put(varName, newValue);
        System.out.println(
                "[ASIGNACIÓN COMPUESTA] " + varName + " = " + varName + " " + op + " " + increment + " => " + newValue);
        statements.add(new Assignment(varName, newValue));
        return newValue;
    }

    @Override
    public Object visitAlmaExpresion(LanguageParser.AlmaExpresionContext ctx) {
        if (ctx.almaTernario() != null) {
            return visit(ctx.almaTernario());
        }

        if (ctx.getChildCount() == 3) {
            Object left = visit(ctx.getChild(0));
            Object right = visit(ctx.getChild(2));
            String op = ctx.getChild(1).getText();

            switch (op) {
                case "+":
                    return add(left, right);
                case "-":
                    return subtract(left, right);
                case "*":
                    return multiply(left, right);
                case "/":
                    return divide(left, right);
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public Object visitAlmaTernario(LanguageParser.AlmaTernarioContext ctx) {
        if (ctx.ALMA_TERNARIO() == null) {
            return visit(ctx.almaLogico());
        }

        boolean condition = asBoolean(visit(ctx.almaLogico()));
        Object result = condition ? visit(ctx.almaExpresion(0)) : visit(ctx.almaExpresion(1));
        return result;
    }

    @Override
    public Object visitAlmaLogico(LanguageParser.AlmaLogicoContext ctx) {
        Object left = visit(ctx.almaIgualdad(0));

        for (int i = 1; i < ctx.almaIgualdad().size(); i++) {
            Object right = visit(ctx.almaIgualdad(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (op.equals("&&")) {
                left = asBoolean(left) && asBoolean(right);
            } else {
                left = asBoolean(left) || asBoolean(right);
            }
        }

        return left;
    }

    @Override
    public Object visitAlmaIgualdad(LanguageParser.AlmaIgualdadContext ctx) {
        Object left = visit(ctx.almaRelacional(0));

        for (int i = 1; i < ctx.almaRelacional().size(); i++) {
            Object right = visit(ctx.almaRelacional(i));
            String op = ctx.getChild(2 * i - 1).getText();

            switch (op) {
                case "==":
                    left = equal(left, right);
                    break;
                case "!=":
                    left = !equal(left, right);
                    break;
            }
        }

        return left;
    }

    @Override
    public Object visitAlmaRelacional(LanguageParser.AlmaRelacionalContext ctx) {
        Object left = visit(ctx.almaAditivo(0));

        for (int i = 1; i < ctx.almaAditivo().size(); i++) {
            Object right = visit(ctx.almaAditivo(i));
            String op = ctx.getChild(2 * i - 1).getText();

            switch (op) {
                case ">":
                    left = greaterThan(left, right);
                    break;
                case "<":
                    left = lessThan(left, right);
                    break;
                case ">=":
                    left = greaterOrEqual(left, right);
                    break;
                case "<=":
                    left = lessOrEqual(left, right);
                    break;
            }
        }

        return left;
    }

    @Override
    public Object visitAlmaAditivo(LanguageParser.AlmaAditivoContext ctx) {
        Object left = visit(ctx.almaMultiplicativo(0));

        for (int i = 1; i < ctx.almaMultiplicativo().size(); i++) {
            Object right = visit(ctx.almaMultiplicativo(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (op.equals("+")) {
                left = add(left, right);
            } else {
                left = subtract(left, right);
            }
        }

        return left;
    }

    @Override
    public Object visitAlmaMultiplicativo(LanguageParser.AlmaMultiplicativoContext ctx) {
        Object left = visit(ctx.almaPrimario(0));

        for (int i = 1; i < ctx.almaPrimario().size(); i++) {
            Object right = visit(ctx.almaPrimario(i));
            String op = ctx.getChild(2 * i - 1).getText();

            switch (op) {
                case "*":
                    left = multiply(left, right);
                    break;
                case "/":
                    left = divide(left, right);
                    break;
                case "%":
                    left = modulo(left, right);
                    break;
            }
        }

        return left;
    }

    @Override
    public Object visitAlmaPrimario(LanguageParser.AlmaPrimarioContext ctx) {
        if (ctx.ALMA_ID() != null) {
            String varName = ctx.ALMA_ID().getText();
            if (!variables.containsKey(varName)) {
                System.err.println(
                        "[ERROR] Variable '" + varName + "' no declarada en la línea " + ctx.getStart().getLine());
                throw new RuntimeException("Variable '" + varName + "' no declarada");
            }
            return variables.get(varName);
        } else if (ctx.ALMA_NUM() != null) {
            return Integer.valueOf(ctx.ALMA_NUM().getText());
        } else if (ctx.ALMA_DECIMAL() != null) {
            return Float.valueOf(ctx.ALMA_DECIMAL().getText());
        } else if (ctx.ALMA_TEXTO() != null) {
            return ctx.ALMA_TEXTO().getText().replaceAll("^\"|\"$", "");
        } else if (ctx.ALMA_BOOLEANO() != null) {
            return ctx.ALMA_BOOLEANO().getText().equals("AlmaLilia.verdadero");
        } else if (ctx.almaExpresion() != null) {
            return visit(ctx.almaExpresion());
        }
        return null;
    }

    @Override
    public Object visitAlmaConsola(LanguageParser.AlmaConsolaContext ctx) {
        Object value = visit(ctx.almaExpresion());
        System.out.println("[CONSOLA] " + value);
        Print printStmt = new Print(value);
        statements.add(printStmt);
        return printStmt; // Devuelve el Statement en lugar del valor
    }

    @Override
    public Object visitAlmaInstruccion(LanguageParser.AlmaInstruccionContext ctx) {
        if (ctx.almaSi() != null) {
            return visit(ctx.almaSi());
        } else if (ctx.almaPara() != null) {
            return visit(ctx.almaPara());
        } else if (ctx.almaAsignar() != null) {
            return visit(ctx.almaAsignar());
        } else if (ctx.almaExpresion() != null) {
            // Solo evalúa la expresión, no la convierte en Statement
            return visit(ctx.almaExpresion());
        } else if (ctx.almaIncremento() != null) {
            return visit(ctx.almaIncremento());
        } else if (ctx.almaImprimir() != null) {
            return visit(ctx.almaImprimir());
        } else if (ctx.almaConsola() != null) {
            return visit(ctx.almaConsola());
        }
        return null;
    }

    @Override
    public Object visitAlmaImprimir(LanguageParser.AlmaImprimirContext ctx) {
        System.out.println("\n=== ESTADO DE VARIABLES ===");
        variables.forEach((name, value) -> {
            String type = variableTypes.getOrDefault(name, "inferido");
            System.out.printf("%s (%s) = %s\n", name, type, value);
        });
        return null;
    }

    @Override
    public Object visitAlmaPara(LanguageParser.AlmaParaContext ctx) {
        Statement init = null;
        if (ctx.almaDeclaracion() != null) {
            visit(ctx.almaDeclaracion());
            init = statements.get(statements.size() - 1);
        } else if (ctx.almaAsignar() != null && !ctx.getChild(2).getText().equals(";")) {
            visit(ctx.almaAsignar(0));
            init = statements.get(statements.size() - 1);
        }

        Object condition = ctx.almaCondicion() != null ? visit(ctx.almaCondicion()) : null;
        Statement update = null;
        if (ctx.almaAsignar() != null && ctx.almaAsignar().size() > (ctx.almaDeclaracion() != null ? 0 : 1)) {
            visit(ctx.almaAsignar(ctx.almaDeclaracion() != null ? 0 : 1));
            update = statements.get(statements.size() - 1);
        } else if (ctx.almaIncremento() != null) {
            visit(ctx.almaIncremento());
            update = statements.get(statements.size() - 1);
        }

        List<Statement> body = new ArrayList<>();
        ctx.almaBloque().almaInstruccion().forEach(instr -> body.add((Statement) visit(instr)));

        statements.add(new ForLoop(init, condition, update, body));

        while (ctx.almaCondicion() == null || evaluateCondition(ctx.almaCondicion())) {
            visit(ctx.almaBloque());

            if (ctx.almaAsignar() != null && ctx.almaAsignar().size() > (ctx.almaDeclaracion() != null ? 0 : 1)) {
                visit(ctx.almaAsignar(ctx.almaDeclaracion() != null ? 0 : 1));
            } else if (ctx.almaIncremento() != null) {
                visit(ctx.almaIncremento());
            }

            if (ctx.almaCondicion() == null) {
                System.out.println("[ADVERTENCIA] Bucle infinito detectado");
                break;
            }
        }
        return null;
    }

    private boolean evaluateCondition(LanguageParser.AlmaCondicionContext ctx) {
        Object result = visit(ctx.almaExpresion());
        if (result instanceof Boolean) {
            return (Boolean) result;
        }
        if (result instanceof Number) {
            return ((Number) result).floatValue() != 0;
        }
        return false;
    }

    private Object convertToType(Object value, String targetType) {
        if (value == null)
            return getDefaultValue(targetType);

        switch (targetType) {
            case "complete":
                if (value instanceof Float)
                    return ((Float) value).intValue();
                if (value instanceof Boolean)
                    return ((Boolean) value) ? 1 : 0;
                if (value instanceof String) {
                    try {
                        return Integer.valueOf((String) value);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                }
                return value;
            case "cacho":
                if (value instanceof Integer)
                    return ((Integer) value).floatValue();
                if (value instanceof Boolean)
                    return ((Boolean) value) ? 1.0f : 0.0f;
                if (value instanceof String) {
                    try {
                        return Float.valueOf((String) value);
                    } catch (NumberFormatException e) {
                        return 0.0f;
                    }
                }
                return value;
            case "pregunta":
                if (value instanceof Number)
                    return ((Number) value).floatValue() != 0;
                if (value instanceof String)
                    return !((String) value).isEmpty();
                return value;
            case "cadena":
                return value.toString();
            default:
                return value;
        }
    }

    private Object getDefaultValue(String type) {
        switch (type) {
            case "complete":
                return 0;
            case "cacho":
                return 0.0f;
            case "pregunta":
                return false;
            case "cadena":
                return "";
            default:
                return null;
        }
    }

    private String inferType(Object value) {
        if (value instanceof Integer)
            return "complete";
        if (value instanceof Float)
            return "cacho";
        if (value instanceof Boolean)
            return "pregunta";
        if (value instanceof String)
            return "cadena";
        return "object";
    }

    private boolean asBoolean(Object obj) {
        if (obj instanceof Boolean)
            return (Boolean) obj;
        if (obj instanceof Number)
            return ((Number) obj).floatValue() != 0;
        if (obj instanceof String)
            return !((String) obj).isEmpty();
        return false;
    }

    private Object add(Object left, Object right) {
        if (left instanceof String || right instanceof String) {
            return (left != null ? left.toString() : "null") + (right != null ? right.toString() : "null");
        }
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) + asFloat(right);
        }
        return asInt(left) + asInt(right);
    }

    private Object subtract(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) - asFloat(right);
        }
        return asInt(left) - asInt(right);
    }

    private Object multiply(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) * asFloat(right);
        }
        return asInt(left) * asInt(right);
    }

    private Object divide(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            float rightVal = asFloat(right);
            return rightVal != 0 ? asFloat(left) / rightVal : 0.0f;
        }
        int rightVal = asInt(right);
        return rightVal != 0 ? asInt(left) / rightVal : 0;
    }

    private Object modulo(Object left, Object right) {
        return asInt(left) % asInt(right);
    }

    private boolean greaterThan(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) > asFloat(right);
        }
        return asInt(left) > asInt(right);
    }

    private boolean lessThan(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) < asFloat(right);
        }
        return asInt(left) < asInt(right);
    }

    private boolean greaterOrEqual(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) >= asFloat(right);
        }
        return asInt(left) >= asInt(right);
    }

    private boolean lessOrEqual(Object left, Object right) {
        if (left instanceof Float || right instanceof Float) {
            return asFloat(left) <= asFloat(right);
        }
        return asInt(left) <= asInt(right);
    }

    private boolean equal(Object left, Object right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.equals(right);
    }

    private float asFloat(Object num) {
        if (num instanceof Integer)
            return ((Integer) num).floatValue();
        if (num instanceof Float)
            return (Float) num;
        return 0.0f;
    }

    private int asInt(Object num) {
        if (num instanceof Integer)
            return (Integer) num;
        if (num instanceof Float)
            return ((Float) num).intValue();
        return 0;
    }
}