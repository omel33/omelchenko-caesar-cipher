package org.cipher.caesar.service;

import java.util.*;


public class CaesarCipher implements Cipher {

    private static final List<Character> ukrainianAlphabet = new LinkedList<>();
    private static final List<Character> englishAlphabet = new LinkedList<>();

    static {
        for (char c = 'А'; c <= 'Я'; c++) {
            ukrainianAlphabet.add(c);
        }
        for (char c = 'а'; c <= 'я'; c++) {
            ukrainianAlphabet.add(c);
        }
        ukrainianAlphabet.add('Ґ');
        ukrainianAlphabet.add('Є');
        ukrainianAlphabet.add('І');
        ukrainianAlphabet.add('Ї');
        ukrainianAlphabet.add('ґ');
        ukrainianAlphabet.add('є');
        ukrainianAlphabet.add('і');
        ukrainianAlphabet.add('ї');

        for (char c = 'A'; c <= 'Z'; c++) {
            englishAlphabet.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            englishAlphabet.add(c);
        }
    }

    @Override
    public String encrypt(List<String> lines, int key) {
        StringBuilder encryptedContent = new StringBuilder();
        for (String line : lines) {
            encryptedContent.append(encryptLine(line, key)).append(System.lineSeparator());
        }
        return encryptedContent.toString();
    }

    @Override
    public String decrypt(List<String> lines, int key) {
        StringBuilder decryptedContent = new StringBuilder();
        for (String line : lines) {
            decryptedContent.append(decryptLine(line, key)).append(System.lineSeparator());
        }
        return decryptedContent.toString();
    }

    private String encryptLine(String line, int key) {
        StringBuilder encryptedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (ukrainianAlphabet.contains(ch)) {
                encryptedLine.append(shiftCharacter(ch, key, ukrainianAlphabet));
            } else if (englishAlphabet.contains(ch)) {
                encryptedLine.append(shiftCharacter(ch, key, englishAlphabet));
            } else {
                encryptedLine.append(ch);
            }
        }
        return encryptedLine.toString();
    }

    private String decryptLine(String line, int key) {
        StringBuilder decryptedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (ukrainianAlphabet.contains(ch)) {
                decryptedLine.append(shiftCharacter(ch, -key, ukrainianAlphabet));
            } else if (englishAlphabet.contains(ch)) {
                decryptedLine.append(shiftCharacter(ch, -key, englishAlphabet));
            } else {
                decryptedLine.append(ch);
            }
        }
        return decryptedLine.toString();
    }

    private char shiftCharacter(char ch, int key, List<Character> alphabet) {
        int index = alphabet.indexOf(ch);
        int newIndex = (index + key + alphabet.size()) % alphabet.size();
        return alphabet.get(newIndex);
    }
}