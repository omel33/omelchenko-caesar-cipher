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
       String[] args= null;
       while (true){
           System.out.println("Enter three arguments.");
           String iput=scanner.nextLine();
           args=iput.split("\\s+");
           if(args.length==3){
               break;
           }else {
               System.out.println("Invalid input");
           }
       }
        return args;
    }
}
