package org.cipher.caesar.io;

import java.util.Scanner;

public class Cli {
    private final Scanner scanner = new Scanner(System.in);

    public void runCli(String commandUser) {

        String command;

        System.out.println("Enter a command (ENCRYPT, DECRYPT, BRUTE_FORCE)):");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim();

            switch (command.toUpperCase()) {
                case "ENCRYPT":
                    System.out.println(" ");
                    break;
                case "DECRYPT":
                    System.out.print(" ");
                    break;
                case "BRUTE_FORCE":
                    System.out.println(" ");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    public String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}



