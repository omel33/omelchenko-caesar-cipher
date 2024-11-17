package org.cipher.caesar.service;

import java.util.List;

public class CaesarCipher implements Cipher {
@Override
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

@Override
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
