package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static java.lang.module.ModuleDescriptor.read;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String PATH = "src/main/resources/File.txt";

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Expected 3 args, not but receive :" + args.length);
            return;
        }

        String command = args[0];
        String path = args[1];
        String key = args[2];
        Command[] cmdValues = Command.values();
        Command inputCmd = null;
        for (Command cmd : cmdValues) {
            if (cmd.toString().equals(command)) {
                inputCmd = cmd;
            }
        }
        if (inputCmd == null) {
            System.out.println("incorrect command:" + command);
            return;
        }
        if (!Files.exists(Path.of(path))) {
            System.out.println("not found path: " + path);
            return;
        }
        int keyAsNumber;
        try {
            keyAsNumber = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException on " + key);
            return;
        }

    }

//    public static void decrypt(String path, int key) {

    public static void decrypt(String path, int key) {
        final String path1 = "src/main/resources/File.txt";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path1))) {
            StringBuilder decryptedContent = new StringBuilder();
            while (fileReader.ready()) {
                final String line = fileReader.readLine();
                decryptedContent.append(decryptLine(line, key)).append("\n");
            }
            System.out.println(decryptedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//        FileSystem fileSystem = FileSystem.getFileSystem();
//        final String path2 = "src/main/resources/File.txt";
//        fileSystem.create(path2);
//        System.out.println("Файл успішно створений");
//        try (InputStream inputStream = fileSystem.newInputStream(path2)) {
//            System.out.print("Вміст файлу:\t");
//            System.out.println(read(inputStream));
//        }
//        try (final OutputStream outputStream = fileSystem.compare(path2)) {
//            outputStream.write("Exstra".getBytes());
//            System.out.println("Дані записані у файл");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try (InputStream inputStream = fileSystem.newInputStream(path2)) {
//            System.out.print("Вміст файлу:\t");
//            System.out.println(read(inputStream));
//        }


    private static String decryptLine(String line, int key) {
        StringBuilder decryptedLine = new StringBuilder();
        for (char character : line.toCharArray()) {

            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base - key + 26) % 26 + base);
            }
            decryptedLine.append(character);
        }
        return decryptedLine.toString();
    }
//    Files.createFile(Path.of("C:\\Users\\Аня\\IdeaProjects\\Exemple\\src\\main\\resources\\FileDECRYPT.txt"));
//    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Аня\\IdeaProjects\\Exemple" +
//      "\\src\\main\\resources\\File.txt");
//     System.out.println(fileOutputStream);
//     Path read = Paths.get("C:\\Users\\Аня\\IdeaProjects\\Exemple\\src\\main\\resources\\File.txt");
//    FileSystem fileSystem = FileSystem.
//    final String read = "C:\\Users\\Аня\\IdeaProjects\\Exemple\\src\\main\\resources\\File.txt";
//    fileSystem;


    private static void encrypt(String path, int key) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("File.txt")));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void fileServis(String file) {
        Path path = Paths.get("src/main/resources/File.txt");
        System.out.println(path);

    }
//    public static void commandTake(String commandAnother){
//        commandAnother=null;
//        if (commandAnother.equals(encrypt())) {
//            return;
//        }
//        if (commandAnother.equals(decrypt())){
//              return;
//        }
//        System.out.println("put command"+commandAnother);
}


//ланрцюг if-else взалежності від команди для кожного випадку пустий метод приймающий ключ та шлях
// створити тектсовий документ та загрузити його для дікріпт та енкріпт в їх методах
//після завантажженя файлу вивкести в консоль