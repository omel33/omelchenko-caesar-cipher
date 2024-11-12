package org.cipher.caesar.service;

import org.cipher.caesar.enums.CommandEnum;
import org.cipher.caesar.io.Cli;

import java.util.Arrays;

public class Raner {
    private final Cli cli = new Cli();


    public boolean shoudUseCli() {
        String input = cli.getUserInput("Enter Y(y) for use Cli or use input args (any)");
        System.out.println("User inPut: " + input);
        return "Y".equals(input) || "y".equals(input);

    }

    public String[] getArgsFromUser() {
        String[] args = new String[3];

        args[0] = cli.getUserInput("Enter command:" + Arrays.toString(CommandEnum.values()));
        args[1] = cli.getUserInput("Write path:");
        args[2] = cli.getUserInput("Write key:");
        return args;
    }


}
