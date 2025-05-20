package com.practica1;

import com.practica1.LanguageCustomVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeTranslator {
    private final List<LanguageCustomVisitor.Statement> statements;

    public CodeTranslator(List<LanguageCustomVisitor.Statement> statements) {
        this.statements = statements;
    }

    public String translate(String targetLanguage) {
        switch (targetLanguage) {
            case "Python":
                return translateToPython();
            case "Java":
                return translateToJava();
            case "Assembly":
                return translateToAssembly();
            default:
                return "Unsupported language: " + targetLanguage;
        }
    }

    private String translateToPython() {
        StringBuilder code = new StringBuilder();
        for (LanguageCustomVisitor.Statement stmt : statements) {
            code.append(translateStatementToPython(stmt, 0)).append("\n");
        }
        return code.toString();
    }

    private String translateStatementToPython(LanguageCustomVisitor.Statement stmt, int indentLevel) {
        String indent = "    ".repeat(indentLevel);

        if (stmt instanceof LanguageCustomVisitor.Declaration) {
            LanguageCustomVisitor.Declaration decl = (LanguageCustomVisitor.Declaration) stmt;
            String value = decl.value != null ? formatValue(decl.value, decl.type) : "";
            return indent + decl.varName + " = " + value;
        }

        if (stmt instanceof LanguageCustomVisitor.Assignment) {
            LanguageCustomVisitor.Assignment assign = (LanguageCustomVisitor.Assignment) stmt;
            return indent + assign.varName + " = " + formatExpression(assign.expression);
        }

        if (stmt instanceof LanguageCustomVisitor.Print) {
            LanguageCustomVisitor.Print print = (LanguageCustomVisitor.Print) stmt;
            return indent + "print(" + formatExpression(print.expression) + ")";
        }

        if (stmt instanceof LanguageCustomVisitor.IfStmt) {
            LanguageCustomVisitor.IfStmt ifStmt = (LanguageCustomVisitor.IfStmt) stmt;
            StringBuilder sb = new StringBuilder();
            sb.append(indent).append("if ").append(formatExpression(ifStmt.condition)).append(":\n");

            for (LanguageCustomVisitor.Statement s : ifStmt.thenBlock) {
                sb.append(translateStatementToPython(s, indentLevel + 1)).append("\n");
            }

            for (LanguageCustomVisitor.ElseIfStmt elseif : ifStmt.elseIfs) {
                sb.append(indent).append("elif ").append(formatExpression(elseif.condition)).append(":\n");
                for (LanguageCustomVisitor.Statement s : elseif.block) {
                    sb.append(translateStatementToPython(s, indentLevel + 1)).append("\n");
                }
            }

            if (!ifStmt.elseBlock.isEmpty()) {
                sb.append(indent).append("else:\n");
                for (LanguageCustomVisitor.Statement s : ifStmt.elseBlock) {
                    sb.append(translateStatementToPython(s, indentLevel + 1)).append("\n");
                }
            }

            return sb.toString().trim();
        }

        if (stmt instanceof LanguageCustomVisitor.ForLoop) {
            LanguageCustomVisitor.ForLoop forLoop = (LanguageCustomVisitor.ForLoop) stmt;
            String init;
            if (forLoop.initialization instanceof LanguageCustomVisitor.Declaration) {
                init = ((LanguageCustomVisitor.Declaration) forLoop.initialization).varName;
            } else {
                init = ((LanguageCustomVisitor.Assignment) forLoop.initialization).varName;
            }
            String end = formatExpression(forLoop.condition);
            
            // Extraer el valor final de la condición de manera más segura
            String endValue;
            if (end.contains("<")) {
                endValue = end.split("<")[1].trim();
            } else if (end.contains("<=")) {
                // Para condiciones con <=, añadimos 1 al valor final
                endValue = end.split("<=")[1].trim() + " + 1";
            } else if (end.contains(">")) {
                // Para bucles descendentes
                endValue = end.split(">")[1].trim();
                return indent + "for " + init + " in range(" + endValue + ", " + init + ", -1):\n" +
                        forLoop.body.stream()
                                .map(s -> translateStatementToPython(s, indentLevel + 1))
                                .collect(Collectors.joining("\n"));
            } else if (end.contains(">=")) {
                // Para bucles descendentes con >=
                endValue = end.split(">=")[1].trim() + " - 1";
                return indent + "for " + init + " in range(" + endValue + ", " + init + ", -1):\n" +
                        forLoop.body.stream()
                                .map(s -> translateStatementToPython(s, indentLevel + 1))
                                .collect(Collectors.joining("\n"));
            } else {
                // Si no podemos determinar el tipo de condición, usamos un valor predeterminado
                endValue = "10";  // Valor predeterminado
            }

            return indent + "for " + init + " in range(" + init + ", " + endValue + "):\n" +
                    forLoop.body.stream()
                            .map(s -> translateStatementToPython(s, indentLevel + 1))
                            .collect(Collectors.joining("\n"));
        }

        return indent + "# Unsupported statement";
    }

    private String translateToJava() {
        StringBuilder code = new StringBuilder();
        code.append("public class TranslatedProgram {\n");
        code.append("    public static void main(String[] args) {\n");
        for (LanguageCustomVisitor.Statement stmt : statements) {
            code.append(translateStatementToJava(stmt, 2)).append("\n");
        }
        code.append("    }\n");
        code.append("}\n");
        return code.toString();
    }

    private String translateStatementToJava(LanguageCustomVisitor.Statement stmt, int indentLevel) {
        String indent = "    ".repeat(indentLevel);
        if (stmt instanceof LanguageCustomVisitor.Declaration) {
            LanguageCustomVisitor.Declaration decl = (LanguageCustomVisitor.Declaration) stmt;
            String type;
            switch (decl.type) {
                case "complete":
                    type = "int";
                    break;
                case "cacho":
                    type = "float";
                    break;
                case "pregunta":
                    type = "boolean";
                    break;
                case "cadena":
                    type = "String";
                    break;
                default:
                    type = decl.type;
                    break;
            }
            String value = decl.value != null ? formatValue(decl.value, decl.type) : getDefaultJavaValue(decl.type);
            return indent + type + " " + decl.varName + " = " + value + ";";
        }

        if (stmt instanceof LanguageCustomVisitor.Assignment) {
            LanguageCustomVisitor.Assignment assign = (LanguageCustomVisitor.Assignment) stmt;
            return indent + assign.varName + " = " + formatExpression(assign.expression) + ";";
        }

        if (stmt instanceof LanguageCustomVisitor.Print) {
            LanguageCustomVisitor.Print print = (LanguageCustomVisitor.Print) stmt;
            return indent + "System.out.println(" + formatExpression(print.expression) + ");";
        }

        if (stmt instanceof LanguageCustomVisitor.IfStmt) {
            LanguageCustomVisitor.IfStmt ifStmt = (LanguageCustomVisitor.IfStmt) stmt;
            StringBuilder sb = new StringBuilder();
            sb.append(indent).append("if (").append(formatExpression(ifStmt.condition)).append(") {\n");

            for (LanguageCustomVisitor.Statement s : ifStmt.thenBlock) {
                sb.append(translateStatementToJava(s, indentLevel + 1)).append("\n");
            }
            sb.append(indent).append("}");

            for (LanguageCustomVisitor.ElseIfStmt elseif : ifStmt.elseIfs) {
                sb.append(" else if (").append(formatExpression(elseif.condition)).append(") {\n");
                for (LanguageCustomVisitor.Statement s : elseif.block) {
                    sb.append(translateStatementToJava(s, indentLevel + 1)).append("\n");
                }
                sb.append(indent).append("}");
            }

            if (!ifStmt.elseBlock.isEmpty()) {
                sb.append(" else {\n");
                for (LanguageCustomVisitor.Statement s : ifStmt.elseBlock) {
                    sb.append(translateStatementToJava(s, indentLevel + 1)).append("\n");
                }
                sb.append(indent).append("}");
            }

            return sb.toString();
        }

        if (stmt instanceof LanguageCustomVisitor.ForLoop) {
            LanguageCustomVisitor.ForLoop forLoop = (LanguageCustomVisitor.ForLoop) stmt;
            String init = translateStatementToJava(forLoop.initialization, 0).trim();
            String cond = formatExpression(forLoop.condition);

            String update;
            if (forLoop.update instanceof LanguageCustomVisitor.Assignment) {
                LanguageCustomVisitor.Assignment assign = (LanguageCustomVisitor.Assignment) forLoop.update;
                update = assign.varName + " = " + formatExpression(assign.expression);
            } else if (forLoop.update instanceof LanguageCustomVisitor.Increment) {
                LanguageCustomVisitor.Increment inc = (LanguageCustomVisitor.Increment) forLoop.update;
                update = inc.varName + inc.operator;
            } else {
                update = "";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(indent).append("for (").append(init).append("; ")
                    .append(cond).append("; ").append(update).append(") {\n");

            for (LanguageCustomVisitor.Statement s : forLoop.body) {
                sb.append(translateStatementToJava(s, indentLevel + 1)).append("\n");
            }
            sb.append(indent).append("}");

            return sb.toString();
        }

        return indent + "// Unsupported statement";
    }

    private String translateToAssembly() {
        StringBuilder code = new StringBuilder();
        code.append("; Simplified Assembly-like Pseudocode\n");
        code.append("section .data\n");

        for (LanguageCustomVisitor.Statement stmt : statements) {
            if (stmt instanceof LanguageCustomVisitor.Declaration) {
                LanguageCustomVisitor.Declaration decl = (LanguageCustomVisitor.Declaration) stmt;
                String value = decl.value != null ? formatValue(decl.value, decl.type) : "0";
                code.append("    ").append(decl.varName).append(" dd ").append(value).append("\n");
            }
        }

        code.append("section .text\n");
        code.append("global _start\n");
        code.append("_start:\n");

        for (LanguageCustomVisitor.Statement stmt : statements) {
            code.append(translateStatementToAssembly(stmt, 1)).append("\n");
        }

        code.append("    mov eax, 1\n");
        code.append("    int 0x80\n");
        return code.toString();
    }

    private String translateStatementToAssembly(LanguageCustomVisitor.Statement stmt, int indentLevel) {
        String indent = "    ".repeat(indentLevel);

        if (stmt instanceof LanguageCustomVisitor.Declaration) {
            return indent + "; Variable declared in .data";
        }

        if (stmt instanceof LanguageCustomVisitor.Assignment) {
            LanguageCustomVisitor.Assignment assign = (LanguageCustomVisitor.Assignment) stmt;
            return indent + "mov eax, " + formatExpression(assign.expression) + "\n" +
                    indent + "mov [" + assign.varName + "], eax";
        }

        if (stmt instanceof LanguageCustomVisitor.Print) {
            LanguageCustomVisitor.Print print = (LanguageCustomVisitor.Print) stmt;
            return indent + "; Print " + formatExpression(print.expression) + " (syscall omitted)";
        }

        if (stmt instanceof LanguageCustomVisitor.IfStmt) {
            LanguageCustomVisitor.IfStmt ifStmt = (LanguageCustomVisitor.IfStmt) stmt;
            String label = "label_" + System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();

            sb.append(indent).append("; If condition ").append(formatExpression(ifStmt.condition)).append("\n");
            sb.append(indent).append("cmp eax, 0\n");
            sb.append(indent).append("je ").append(label).append("_else\n");

            for (LanguageCustomVisitor.Statement s : ifStmt.thenBlock) {
                sb.append(translateStatementToAssembly(s, indentLevel)).append("\n");
            }

            sb.append(indent).append("jmp ").append(label).append("_end\n");
            sb.append(label).append("_else:\n");

            for (LanguageCustomVisitor.Statement s : ifStmt.elseBlock) {
                sb.append(translateStatementToAssembly(s, indentLevel)).append("\n");
            }

            sb.append(label).append("_end:\n");
            return sb.toString();
        }

        if (stmt instanceof LanguageCustomVisitor.ForLoop) {
            LanguageCustomVisitor.ForLoop forLoop = (LanguageCustomVisitor.ForLoop) stmt;
            String label = "loop_" + System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();

            sb.append(indent).append("; For loop\n");
            sb.append(translateStatementToAssembly(forLoop.initialization, indentLevel)).append("\n");
            sb.append(label).append("_start:\n");

            // Extraer el valor final de la condición de manera más segura
            String compareValue = "";
            String compareOp = "jge"; // Por defecto para bucles ascendentes
            
            String condition = formatExpression(forLoop.condition);
            if (condition.contains("<")) {
                compareValue = condition.split("<")[1].trim();
            } else if (condition.contains("<=")) {
                compareValue = condition.split("<=")[1].trim();
                // Ajustar para incluir el valor final
                sb.append(indent).append("; Incluye el valor final en <=\n");
            } else if (condition.contains(">")) {
                compareValue = condition.split(">")[1].trim();
                compareOp = "jle"; // Para bucles descendentes
            } else if (condition.contains(">=")) {
                compareValue = condition.split(">=")[1].trim();
                compareOp = "jl"; // Para bucles descendentes incluyendo el valor final
            } else {
                // Si no podemos determinar el tipo de condición, usamos un valor predeterminado
                compareValue = "10";
            }

            if (forLoop.initialization instanceof LanguageCustomVisitor.Declaration) {
                LanguageCustomVisitor.Declaration decl = (LanguageCustomVisitor.Declaration) forLoop.initialization;
                sb.append(indent).append("cmp ").append(decl.varName).append(", ")
                        .append(compareValue).append("\n");
            } else if (forLoop.initialization instanceof LanguageCustomVisitor.Assignment) {
                LanguageCustomVisitor.Assignment assign = (LanguageCustomVisitor.Assignment) forLoop.initialization;
                sb.append(indent).append("cmp ").append(assign.varName).append(", ")
                        .append(compareValue).append("\n");
            }

            sb.append(indent).append(compareOp).append(" ").append(label).append("_end\n");

            for (LanguageCustomVisitor.Statement s : forLoop.body) {
                sb.append(translateStatementToAssembly(s, indentLevel)).append("\n");
            }

            sb.append(translateStatementToAssembly(forLoop.update, indentLevel)).append("\n");
            sb.append(indent).append("jmp ").append(label).append("_start\n");
            sb.append(label).append("_end:");

            return sb.toString();
        }

        return indent + "; Unsupported statement";
    }

    private String formatValue(Object value, String type) {
        if (value == null)
            return getDefaultValue(type);
        if (value instanceof String)
            return "\"" + value + "\"";
        if (value instanceof Boolean) {
            return value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
        }
        return value.toString();
    }

    private String getDefaultValue(String type) {
        switch (type) {
            case "complete":
                return "0";
            case "cacho":
                return "0.0";
            case "pregunta":
                return "False";
            case "cadena":
                return "\"\"";
            default:
                return "null";
        }
    }

    private String getDefaultJavaValue(String type) {
        switch (type) {
            case "complete":
                return "0";
            case "cacho":
                return "0.0f";
            case "pregunta":
                return "false";
            case "cadena":
                return "\"\"";
            default:
                return "null";
        }
    }

    private String formatExpression(Object expr) {
        if (expr instanceof String) {
            return "\"" + expr + "\"";
        } else if (expr instanceof Boolean) {
            return expr.toString().substring(0, 1).toUpperCase() + expr.toString().substring(1);
        }
        return expr.toString();
    }

    // Método para obtener la extensión correcta
    public String getFileExtension(String targetLanguage) {
        switch (targetLanguage) {
            case "Python":
                return ".py";
            case "Java":
                return ".java";
            case "Assembly":
                return ".asm";
            default:
                return ".alma"; // Extensión por defecto
        }
    }
}