package com.practica1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.StringReader;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.File;

public class TranslatorApp {
    private JFrame frame;
    private JTextArea codeEditor;
    private JTextArea outputArea;
    private JTextArea consoleArea;
    private JComboBox<String> languageSelector;

    public TranslatorApp() {
        // Initialize the main frame
        frame = new JFrame("Custom Language Translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(18, 18, 18));

        // Top: Button bar and language selector
        JPanel buttonBar = new JPanel();
        buttonBar.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonBar.setBackground(new Color(46, 46, 46));
        buttonBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Modificar los botones existentes
        JButton importButton = new JButton("Importar");
        JButton executeButton = new JButton("Ejecutar");
        JButton translateButton = new JButton("Traducir");
        JButton executeTranslationButton = new JButton("Ejecutar Traducción");
        JButton exportButton = new JButton("Exportar Traducción");
        JButton exportOutputButton = new JButton("Exportar ALMA");
        languageSelector = new JComboBox<>(new String[] { "Python", "Java", "Assembly" });
        languageSelector.setSelectedItem("Python");

        // Estilo para el botón de ejecutar traducción
        executeTranslationButton.setBackground(new Color(76, 175, 80));
        executeTranslationButton.setForeground(Color.WHITE);
        executeTranslationButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        executeTranslationButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        executeTranslationButton.setFocusPainted(false);

        // Estilo para el nuevo botón
        exportOutputButton.setBackground(new Color(63, 81, 181));
        exportOutputButton.setForeground(Color.WHITE);
        exportOutputButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        exportOutputButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        exportOutputButton.setFocusPainted(false);
        exportOutputButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportOutputButton.setBackground(new Color(57, 73, 171));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportOutputButton.setBackground(new Color(63, 81, 181));
            }
        });

        // Style language selector
        languageSelector.setBackground(Color.WHITE);
        languageSelector.setForeground(Color.BLACK);
        languageSelector.setFont(new Font("SansSerif", Font.PLAIN, 14));
        languageSelector.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        buttonBar.add(importButton);
        buttonBar.add(executeButton);
        buttonBar.add(translateButton);
        buttonBar.add(executeTranslationButton);
        buttonBar.add(languageSelector);
        buttonBar.add(exportButton);
        buttonBar.add(exportOutputButton);

        // Crear panel vertical para output y consola
        JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        verticalSplitPane.setResizeWeight(0.7);
        verticalSplitPane.setBorder(null);

        // Center: Code editor and output area
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(450);
        splitPane.setResizeWeight(0.5);
        splitPane.setBorder(null);

        // Configurar área de consola
        consoleArea = new JTextArea();
        consoleArea.setText("Consola del sistema...");
        consoleArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        consoleArea.setBackground(new Color(24, 24, 24));
        consoleArea.setForeground(new Color(158, 158, 158));
        consoleArea.setCaretColor(Color.WHITE);
        consoleArea.setEditable(false);
        consoleArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane consoleScroll = new JScrollPane(consoleArea);
        consoleScroll.setBorder(null);

        // Label para la consola
        JLabel consoleLabel = new JLabel("Consola");
        consoleLabel.setForeground(Color.WHITE);
        consoleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Panel para la consola
        JPanel consoleBox = new JPanel(new BorderLayout(0, 5));
        consoleBox.setBackground(new Color(18, 18, 18));
        consoleBox.setBorder(new EmptyBorder(5, 5, 5, 5));
        consoleBox.add(consoleLabel, BorderLayout.NORTH);
        consoleBox.add(consoleScroll, BorderLayout.CENTER);

        // Code editor
        codeEditor = new JTextArea();
        codeEditor.setText("Write your custom language code here...");
        codeEditor.setFont(new Font("Monospaced", Font.PLAIN, 14));
        codeEditor.setBackground(new Color(30, 30, 30));
        codeEditor.setForeground(Color.WHITE);
        codeEditor.setCaretColor(Color.WHITE);
        codeEditor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Output area
        outputArea = new JTextArea();
        outputArea.setText("Execution output will appear here...");
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBackground(new Color(30, 30, 30));
        outputArea.setForeground(Color.WHITE);
        outputArea.setCaretColor(Color.WHITE);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Wrap text areas in scroll panes
        JScrollPane editorScroll = new JScrollPane(codeEditor);
        editorScroll.setBorder(null);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(null);

        // Labels for sections
        JLabel editorLabel = new JLabel("Code Editor");
        editorLabel.setForeground(Color.WHITE);
        editorLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel outputLabel = new JLabel("Output");
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Panels for editor and output with labels
        JPanel editorBox = new JPanel(new BorderLayout(0, 5));
        editorBox.setBackground(new Color(18, 18, 18));
        editorBox.setBorder(new EmptyBorder(5, 5, 5, 5));
        editorBox.add(editorLabel, BorderLayout.NORTH);
        editorBox.add(editorScroll, BorderLayout.CENTER);

        JPanel outputBox = new JPanel(new BorderLayout(0, 5));
        outputBox.setBackground(new Color(18, 18, 18));
        outputBox.setBorder(new EmptyBorder(5, 5, 5, 5));
        outputBox.add(outputLabel, BorderLayout.NORTH);
        outputBox.add(outputScroll, BorderLayout.CENTER);

        // Configurar el split vertical
        verticalSplitPane.setTopComponent(outputBox);
        verticalSplitPane.setBottomComponent(consoleBox);

        splitPane.setLeftComponent(editorBox);
        splitPane.setRightComponent(verticalSplitPane);

        // Add components to frame
        frame.add(buttonBar, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);

        // Button actions
        importButton.addActionListener(e -> importCode());
        executeButton.addActionListener(e -> executeCode());
        translateButton.addActionListener(e -> translateCode());
        executeTranslationButton.addActionListener(e -> executeTranslation());
        exportButton.addActionListener(e -> exportCode());
        exportOutputButton.addActionListener(e -> exportOriginalCode());

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void importCode() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Import Code");
        fileChooser.setFileFilter(new FileNameExtensionFilter("ALMA Files", "alma"));

        int userSelection = fileChooser.showOpenDialog(frame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try {
                String content = Files.readString(fileToOpen.toPath());
                codeEditor.setText(content);
                outputArea.setText("File imported successfully: " + fileToOpen.getName());
            } catch (IOException ex) {
                outputArea.setText("Error importing file: " + ex.getMessage());
            }
        }
    }

    private void exportCode() {
        String targetLanguage = (String) languageSelector.getSelectedItem();
        String extension = getFileExtension(targetLanguage);
        
        // Primero traducir el código
        try {
            String code = codeEditor.getText();
            
            CharStream input = CharStreams.fromString(code);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            LanguageParser.AlmaProgramaContext tree = parser.almaPrograma();

            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            visitor.visit(tree);

            List<LanguageCustomVisitor.Statement> statements = visitor.getStatements();
            CodeTranslator translator = new CodeTranslator(statements);
            String translatedCode = translator.translate(targetLanguage);
            
            // Ahora exportar el código traducido
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Exportar Código Traducido");
            fileChooser.setFileFilter(new FileNameExtensionFilter(
                    targetLanguage + " Files (*" + extension + ")", extension.substring(1)));

            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                // Asegurar la extensión correcta
                if (!fileToSave.getName().toLowerCase().endsWith(extension)) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + extension);
                }

                Files.writeString(fileToSave.toPath(), translatedCode);
                outputArea.setText("Código traducido exportado exitosamente: " + fileToSave.getName());
            }
        } catch (Exception ex) {
            outputArea.setText("Error al exportar el código traducido: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    // Método para obtener la extensión correcta según el lenguaje
    private String getFileExtension(String targetLanguage) {
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

    private void executeCode() {
        try {
            consoleArea.setText("Ejecutando código ALMA...\n");
            String code = codeEditor.getText();

            CharStream input = CharStreams.fromString(code);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            LanguageParser.AlmaProgramaContext tree = parser.almaPrograma();

            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            visitor.visit(tree);

            // Obtener la salida del visitor
            List<LanguageCustomVisitor.Statement> statements = visitor.getStatements();
            StringBuilder output = new StringBuilder();
            
            // Procesar cada statement y obtener su salida
            for (LanguageCustomVisitor.Statement stmt : statements) {
                output.append(stmt.execute()).append("\n");
            }

            consoleArea.append("Resultado de la ejecución:\n");
            consoleArea.append(output.toString());
        } catch (Exception ex) {
            consoleArea.append("Error en la ejecución: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    private void translateCode() {
        try {
            outputArea.setText("");
            consoleArea.setText("Traduciendo código...\n");
            String code = codeEditor.getText();
            String targetLanguage = (String) languageSelector.getSelectedItem();

            CharStream input = CharStreams.fromString(code);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            LanguageParser.AlmaProgramaContext tree = parser.almaPrograma();

            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            visitor.visit(tree);

            List<LanguageCustomVisitor.Statement> statements = visitor.getStatements();
            CodeTranslator translator = new CodeTranslator(statements);
            String translatedCode = translator.translate(targetLanguage);

            consoleArea.append("Traducción completada exitosamente.\n");
            outputArea.setText(translatedCode);
        } catch (Exception ex) {
            consoleArea.append("Error en la traducción: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    private void exportOriginalCode() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Exportar Código ALMA");
            fileChooser.setFileFilter(new FileNameExtensionFilter("ALMA Files (*.alma)", "alma"));

            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if (!fileToSave.getName().toLowerCase().endsWith(".alma")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".alma");
                }

                Files.writeString(fileToSave.toPath(), codeEditor.getText());
                consoleArea.setText("Código ALMA exportado exitosamente: " + fileToSave.getName());
            }
        } catch (Exception ex) {
            consoleArea.setText("Error al exportar el código ALMA: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void executeTranslation() {
        try {
            // Primero traducir
            translateCode();
            
            // Obtener el código traducido y formatear si es Python
            String translatedCode = outputArea.getText();
            String targetLanguage = (String) languageSelector.getSelectedItem();
            
            if (targetLanguage.equals("Python")) {
                translatedCode = formatPythonCode(translatedCode);
            } else if (targetLanguage.equals("Java")) {
                // Asegurarnos de que el código Java tenga una clase pública con el nombre correcto
                translatedCode = formatJavaCode(translatedCode);
            }
            
            // Crear un archivo temporal para el código traducido
            File tempFile = File.createTempFile("Main", getFileExtension(targetLanguage));
            Files.writeString(tempFile.toPath(), translatedCode);
            
            // Preparar el proceso según el lenguaje
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.redirectErrorStream(true);
            
            switch (targetLanguage) {
                case "Python":
                    processBuilder.command("python", tempFile.getAbsolutePath());
                    break;
                    
                case "Java":
                    // Compilar primero
                    ProcessBuilder compileBuilder = new ProcessBuilder(
                        "javac", tempFile.getAbsolutePath()
                    );
                    Process compileProcess = compileBuilder.start();
                    
                    // Leer errores de compilación si los hay
                    try (var reader = new java.io.BufferedReader(
                            new java.io.InputStreamReader(compileProcess.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            consoleArea.append(line + "\n");
                        }
                    }
                    
                    int compileResult = compileProcess.waitFor();
                    if (compileResult != 0) {
                        consoleArea.append("Error al compilar el código Java\n");
                        return;
                    }
                    
                    // Luego ejecutar
                    processBuilder.command("java", "-cp", tempFile.getParent(), "Main");
                    break;
                    
                case "Assembly":
                    consoleArea.append("La ejecución directa de código Assembly no está soportada.\n");
                    return;
            }
            
            // Ejecutar el proceso
            Process process = processBuilder.start();
            
            // Leer la salida del proceso
            try (var reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()))) {
                
                consoleArea.setText("=== Ejecutando código traducido ===\n");
                String line;
                while ((line = reader.readLine()) != null) {
                    consoleArea.append(line + "\n");
                }
            }
            
            // Esperar a que termine el proceso
            process.waitFor();
            consoleArea.append("\n=== Ejecución completada ===\n");
            
            // Limpiar archivos temporales
            tempFile.delete();
            if (targetLanguage.equals("Java")) {
                new File(tempFile.getParent(), tempFile.getName().replace(".java", ".class")).delete();
            }
            
        } catch (Exception ex) {
            consoleArea.append("Error al ejecutar la traducción: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    // Agregar método para formatear código Java
    private String formatJavaCode(String code) {
        // Asegurarnos de que la clase sea pública y se llame Main con un método main
        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append("public class Main {\n");
        formattedCode.append("    public static void main(String[] args) {\n");
        
        // Formatear el código y corregir todas las ocurrencias de True por true
        String formattedInnerCode = code.replace(" True ", " true ")
                                      .replace("(True)", "(true)")
                                      .replace(" True;", " true;")
                                      .replace("=True", "=true")
                                      .replace("for (int i = 0;; True; i++)", "while (true)")
                                      .replace("\n", "\n        ");
        
        formattedCode.append("        ").append(formattedInnerCode);
        formattedCode.append("\n    }\n");
        formattedCode.append("}\n");
        return formattedCode.toString();
    }

    // Método auxiliar para formatear código Python
    private String formatPythonCode(String code) {
        StringBuilder formattedCode = new StringBuilder();
        String[] lines = code.split("\n");
        int indentLevel = 0;
        
        for (String line : lines) {
            String trimmedLine = line.trim();
            
            // Reducir la indentación para líneas que cierran bloques
            if (trimmedLine.startsWith("}") || trimmedLine.startsWith("elif") || trimmedLine.startsWith("else:")) {
                indentLevel = Math.max(0, indentLevel - 1);
            }
            
            // Agregar la indentación correcta
            if (!trimmedLine.isEmpty()) {
                formattedCode.append("    ".repeat(indentLevel)).append(trimmedLine).append("\n");
            } else {
                formattedCode.append("\n"); // Mantener líneas vacías
            }
            
            // Aumentar la indentación después de líneas que abren bloques
            if (trimmedLine.endsWith(":")) {
                indentLevel++;
            }
        }
        
        return formattedCode.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TranslatorApp::new);
    }
}
