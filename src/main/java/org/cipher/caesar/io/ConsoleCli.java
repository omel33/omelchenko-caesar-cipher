package org.cipher.caesar.io;

import java.util.Scanner;

public class ConsoleCli implements Cli {
    private final Scanner scanner = new Scanner(System.in);

        @Override
    public String getUserInput(String message) {

        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void displayOutput(String message) {
        System.out.println(message);
    }
}



