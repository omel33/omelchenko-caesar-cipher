package org.example;

import java.nio.file.Files;
import java.nio.file.Path;


import static java.lang.module.ModuleDescriptor.read;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        var raner=new Raner();
        var processor = new DecryptEncrypt();
        var fileServise = new FileServise();
        if(raner.shoudUseCli()){
            args=raner.getArgsFromUser();
        }
        if (args.length != 3) {
            System.out.println("Expected 3 args, not but receive :" + args.length);
            return;
        }

        String command = args[0];
        String path = args[1];
        String key = args[2];
        Command[] cmdValues = Command.values();
        Command inputCmd = null;
        for (Command cmd : cmdValues) {
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
        if ((Command.DECRYPT).equals(inputCmd)) {
            var lines = fileServise.readLines(path);
            var decryptData = processor.decrypt(lines, keyAsNumber);
            if (!path.contains("ENCRYPTED")) {
                throw new RuntimeException("Incorect file extension");
            }
            var outPutPath = path.replace("ENCRYPTED", "DECRYPTED");
            fileServise.write(outPutPath, decryptData);
        }
        if ((Command.ENCRYPT).equals(inputCmd)) {
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

