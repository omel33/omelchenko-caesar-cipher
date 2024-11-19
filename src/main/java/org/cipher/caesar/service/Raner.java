package org.cipher.caesar.service;

import org.cipher.caesar.enums.CommandEnum;
import org.cipher.caesar.io.Cli;
import org.cipher.caesar.io.ConsoleCli;
import org.cipher.caesar.io.FileServise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Raner {
    private final Cli cli = new ConsoleCli();
    private final CaesarCipher processor = new CaesarCipher();
    private final FileServise fileServise = new FileServise();

    private boolean shoudUseCli() {
        String input = cli.getUserInput("Enter Y(y) for use Cli or use input args (any)");
        System.out.println("User inPut: " + input);
        return  "Y".equals(input) || "y".equals(input);

    }

    private String[] getArgsFromUser() {
        String[] args = new String[3];

        args[0] = cli.getUserInput("Enter command:" + Arrays.toString(CommandEnum.values()) );
        args[1] = cli.getUserInput("Write path:");
        args[2] = cli.getUserInput("Write key:");
        return args;
    }

    public void run(String[] args) {

        if (shoudUseCli()) {
            args = getArgsFromUser();
        }
        if (args.length != 3) {
            System.out.println("Expected 3 args, not but receive :" + args.length);
            return;
        }

        String command = args[0];
        String path = args[1];
        String key = args[2];
        CommandEnum[] cmdValues = CommandEnum.values();
        CommandEnum inputCmd = null;
        for (CommandEnum cmd : cmdValues) {
            if (cmd.toString().equals(command)) {
                inputCmd = cmd;
            }
        }
        if (inputCmd == null) {
            System.out.println("incorrect command:" + command);
            return;
        }
        if (!Files.exists(Path.of(path))) {
            System.out.println("not found path: " + path);
            return;
        }
        int keyAsNumber;
        try {
            keyAsNumber = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException on " + key);
            return;
        }
        if ((CommandEnum.DECRYPT).equals(inputCmd)) {
            var lines = fileServise.readLines(path);
            var decryptData = processor.decrypt(lines, keyAsNumber);
            if (!path.contains("ENCRYPTED")) {
                throw new RuntimeException("Incorect file extension");
            }
            var outPutPath = path.replace("ENCRYPTED", "DECRYPTED");
            fileServise.write(outPutPath, decryptData);
        }
        if ((CommandEnum.ENCRYPT).equals(inputCmd)) {
            var lines = fileServise.readLines(path);
            var encryptData = processor.encrypt(lines, keyAsNumber);
            if (!path.endsWith(".txt")) {
                throw new RuntimeException("Incorect file extension");
            }
            var outPutPath = path.replace(".txt", "-ENCRYPTED.txt");
            fileServise.write(outPutPath, encryptData);
        }
    }

}
