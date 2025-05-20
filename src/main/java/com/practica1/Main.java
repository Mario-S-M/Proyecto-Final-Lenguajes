package com.practica1;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "alma";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0 ? new String[]{"test." + EXTENSION} : args;
        System.out.println("Dirbase: " + DIRBASE);
        
        for (String file : files) {
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            LanguageLexer lexer = new LanguageLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            
            // Cambiado de program() a almaPrograma() para coincidir con tu gramática
            LanguageParser.AlmaProgramaContext tree = parser.almaPrograma();
            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            visitor.visit(tree);

            System.out.println("FINISH: " + file);
        }
    }
}