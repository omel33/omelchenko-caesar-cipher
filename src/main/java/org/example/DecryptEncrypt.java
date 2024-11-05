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
    public String decrypt(List<String> lines, int key) {

        System.out.println("decryptFiles");
        StringBuilder decryptedContent = new StringBuilder();
        for (String line : lines) {
            decryptedContent.append(decryptLine(line, key)).append(System.lineSeparator());
        }
        return decryptedContent.toString();

    }


    private String decryptLine(String line, int key) {
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


    public String encrypt(List<String> lines, int key) {
            StringBuilder encryptedContent = new StringBuilder();
        for (String line:lines) {
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base + key) % 26 + base);
                }
                encryptedContent.append(c);
            }
            encryptedContent.append(System.lineSeparator());
        }
            return encryptedContent.toString();


    }
}
