package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DecryptEncrypt {
    protected static void decrypt(String path, int key) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            StringBuilder decryptedContent = new StringBuilder();
            while (fileReader.ready()) {
                lines.add(fileReader.readLine());
            }
            System.out.println(decryptedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("decryptFiles");
        StringBuilder decryptedContent = new StringBuilder();
        for (String line : lines) {
            decryptedContent.append(decryptLine(line, key)).append(System.lineSeparator());
        }
        String outPut = path.replace("ENCRYPTED", "DECRYPTED");
        try {
            Files.write(Path.of(outPut), decryptedContent.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


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


    protected static void encrypt(String path, int key) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            StringBuilder encryptedContent = new StringBuilder();

            for (char c : content.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base + key) % 26 + base);
                }
                encryptedContent.append(c);
            }

            Files.write(Paths.get("C:\\Users\\Аня\\IdeaProjects\\Exemple\\src\\main\\resources\\File-ENCRYPTED.txt"),
                    encryptedContent.toString().getBytes());
            System.out.println("encryptFiles");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
