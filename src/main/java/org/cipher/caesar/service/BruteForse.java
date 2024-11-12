package org.cipher.caesar.service;

public class BruteForse {
    public void runBruteForse(String[] text){
        String cipherText = "cccccCCCCWdnh wklv rqolqh whvw. Wkhuh duh 60 pxowlsoh-fkrlfh txhvwlrqv\n" +
                "dqg wkhuh lv qr wlph olplw. Brx zloo eh deoh wr vhh wkh dqvzhuv zkhq brx ilqlvk wkh whvw."; // Зашифрований текст
        BruteForce(cipherText);
    }

    public static void BruteForce(String ciphertext) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int key = 0; key < alphabet.length(); key++) {
            StringBuilder plainText = new StringBuilder();
            for (char character : ciphertext.toCharArray()) {
                if (Character.isLetter(character)) {
                    int index = (alphabet.indexOf(character) - key + alphabet.length()) % alphabet.length();
                    plainText.append(alphabet.charAt(index));
                } else {
                    plainText.append(character);
                }
            }
            System.out.println("Key " + key + ": " + plainText);
        }
    }

}