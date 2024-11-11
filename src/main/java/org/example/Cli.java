package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cli {
    public static void runCli(String commandUser) {
        Scanner scanner = new Scanner(System.in);
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
}



