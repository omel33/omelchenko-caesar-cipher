package org.cipher.caesar.service;

import java.util.*;


public class CaesarCipher implements Cipher {

    private static final Map<Character, Integer> charToCodeMap = new HashMap<>();
    private static final Map<Integer, Character> codeToCharMap = new HashMap<>();
    private static final List<Character> symbolList = new LinkedList<>();

    static {
        // Заповнюємо мапу символ-код для українських літер
        charToCodeMap.put('А', 1040);
        charToCodeMap.put('Б', 1041);
        charToCodeMap.put('В', 1042);
        charToCodeMap.put('Г', 1043);
        charToCodeMap.put('Ґ', 1168);
        charToCodeMap.put('Д', 1044);
        charToCodeMap.put('Е', 1045);
        charToCodeMap.put('Є', 1028);
        charToCodeMap.put('Ж', 1046);
        charToCodeMap.put('З', 1047);
        charToCodeMap.put('И', 1048);
        charToCodeMap.put('І', 1030);
        charToCodeMap.put('Ї', 1031);
        charToCodeMap.put('Й', 1049);
        charToCodeMap.put('К', 1050);
        charToCodeMap.put('Л', 1051);
        charToCodeMap.put('М', 1052);
        charToCodeMap.put('Н', 1053);
        charToCodeMap.put('О', 1054);
        charToCodeMap.put('П', 1055);
        charToCodeMap.put('Р', 1056);
        charToCodeMap.put('С', 1057);
        charToCodeMap.put('Т', 1058);
        charToCodeMap.put('У', 1059);
        charToCodeMap.put('Ф', 1060);
        charToCodeMap.put('Х', 1061);
        charToCodeMap.put('Ц', 1062);
        charToCodeMap.put('Ч', 1063);
        charToCodeMap.put('Ш', 1064);
        charToCodeMap.put('Щ', 1065);
        charToCodeMap.put('Ь', 1068);
        charToCodeMap.put('Ю', 1070);
        charToCodeMap.put('Я', 1071);
        charToCodeMap.put('а', 1072);
        charToCodeMap.put('б', 1073);
        charToCodeMap.put('в', 1074);
        charToCodeMap.put('г', 1075);
        charToCodeMap.put('ґ', 1169);
        charToCodeMap.put('д', 1076);
        charToCodeMap.put('е', 1077);
        charToCodeMap.put('є', 1108);
        charToCodeMap.put('ж', 1078);
        charToCodeMap.put('з', 1079);
        charToCodeMap.put('и', 1080);
        charToCodeMap.put('і', 1110);
        charToCodeMap.put('ї', 1111);
        charToCodeMap.put('й', 1081);
        charToCodeMap.put('к', 1082);
        charToCodeMap.put('л', 1083);
        charToCodeMap.put('м', 1084);
        charToCodeMap.put('н', 1085);
        charToCodeMap.put('о', 1086);
        charToCodeMap.put('п', 1087);
        charToCodeMap.put('р', 1088);
        charToCodeMap.put('с', 1089);
        charToCodeMap.put('т', 1090);
        charToCodeMap.put('у', 1091);
        charToCodeMap.put('ф', 1092);
        charToCodeMap.put('х', 1093);
        charToCodeMap.put('ц', 1094);
        charToCodeMap.put('ч', 1095);
        charToCodeMap.put('ш', 1096);
        charToCodeMap.put('щ', 1097);
        charToCodeMap.put('ь', 1100);
        charToCodeMap.put('ю', 1102);
        charToCodeMap.put('я', 1103);

        // Додаємо англійські літери
        for (char c = 'A'; c <= 'Z'; c++) {
            charToCodeMap.put(c, (int) c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            charToCodeMap.put(c, (int) c);
        }

        // Створюємо зворотну мапу код-символ та заповнюємо LinkedList
        for (Map.Entry<Character, Integer> entry : charToCodeMap.entrySet()) {
            codeToCharMap.put(entry.getValue(), entry.getKey());
            symbolList.add(entry.getKey());
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
            if (charToCodeMap.containsKey(ch)) {
                ListIterator<Character> iterator = symbolList.listIterator();
                while (iterator.hasNext()) {
                    char currentChar = iterator.next();
                    if (currentChar == ch) {
                        for (int i = 0; i < key; i++) {
                            if (!iterator.hasNext()) {
                                iterator = symbolList.listIterator(); // Повертаємося на початок
                            }
                            currentChar = iterator.next();
                        }
                        encryptedLine.append(currentChar);
                        break;
                    }
                }
            } else {
                encryptedLine.append(ch);
            }
        }
        return encryptedLine.toString();
    }

    private String decryptLine(String line, int key) {
        StringBuilder decryptedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (charToCodeMap.containsKey(ch)) {
                ListIterator<Character> iterator = symbolList.listIterator(symbolList.size());
                while (iterator.hasPrevious()) {
                    char currentChar = iterator.previous();
                    if (currentChar == ch) {
                        for (int i = 0; i < key; i++) {
                            if (!iterator.hasPrevious()) {
                                iterator = symbolList.listIterator(symbolList.size()); // Повертаємося в кінець
                            }
                            currentChar = iterator.previous();
                        }
                        decryptedLine.append(currentChar);
                        break;
                    }
                }
            } else {
                decryptedLine.append(ch);
            }
        }
        return decryptedLine.toString();
    }
}