package org.cipher.caesar.io;

import java.util.Scanner;

public class ConsoleCli implements Cli {
    private final Scanner scanner = new Scanner(System.in);

        @Override
    public String getUserInput(String massedge) {

        System.out.println("Enter Y(y) for use Cli or use input args (any)");
        return scanner.nextLine();
    }

    @Override
    public void displayOutput(String message) {
        System.out.println(message);
    }
}



