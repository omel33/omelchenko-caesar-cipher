package org.example;

import java.util.Scanner;

public class Raner {
    private Scanner scanner = new Scanner(System.in);

    public boolean shoudUseCli() {
        System.out.println("Enter Y(y) for use Cli or use input args (any)");
        String inPut=scanner.nextLine();
        System.out.println("User inPut: "+ inPut);
        return "Y".equals(inPut) || "y".equals(inPut);

    }

    public String[] getArgsFromUser() {
        //todo: implement
        return null;
    }
}
