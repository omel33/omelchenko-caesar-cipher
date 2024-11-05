package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static java.lang.module.ModuleDescriptor.read;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        if ((Command.DECRYPT).equals(inputCmd)) {
            DecryptEncrypt.decrypt(path, keyAsNumber);
        }
        if ((Command.ENCRYPT).equals(inputCmd)) {
            DecryptEncrypt.encrypt(path, keyAsNumber);
        }

    }


//    public static void decrypt(String path, int key) {
//        List<String> lines = new ArrayList<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
//            StringBuilder decryptedContent = new StringBuilder();
//            while (fileReader.ready()) {
//                lines.add(fileReader.readLine());
//            }
//            System.out.println(decryptedContent.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("decryptFiles");
//        StringBuilder decryptedContent = new StringBuilder();
//        for (String line : lines) {
//            decryptedContent.append(decryptLine(line, key)).append(System.lineSeparator());
//        }
//        String outPut = path.replace("ENCRYPTED", "DECRYPTED");
//        try {
//            Files.write(Path.of(outPut), decryptedContent.toString().getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    private static String decryptLine(String line, int key) {
//        StringBuilder decryptedLine = new StringBuilder();
//        for (char character : line.toCharArray()) {
//
//            if (Character.isLetter(character)) {
//                char base = Character.isLowerCase(character) ? 'a' : 'A';
//                character = (char) ((character - base - key + 26) % 26 + base);
//            }
//            decryptedLine.append(character);
//        }
//        return decryptedLine.toString();
//    }
//
//
//    private static void encrypt(String path, int key) {
//        try {
//            String content = new String(Files.readAllBytes(Paths.get(path)));
//            StringBuilder encryptedContent = new StringBuilder();
//
//            for (char c : content.toCharArray()) {
//                if (Character.isLetter(c)) {
//                    char base = Character.isUpperCase(c) ? 'A' : 'a';
//                    c = (char) ((c - base + key) % 26 + base);
//                }
//                encryptedContent.append(c);
//            }
//
//            Files.write(Paths.get("C:\\Users\\Аня\\IdeaProjects\\Exemple\\src\\main\\resources\\File-ENCRYPTED.txt"),
//                    encryptedContent.toString().getBytes());
//            System.out.println("encryptFiles");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    private static void fileServis(String file) {
        Path path = Paths.get("src/main/resources/File-ENCRYPTED.txt");
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


