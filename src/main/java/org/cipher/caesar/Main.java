package org.cipher.caesar;

import org.cipher.caesar.enums.CommandEnum;
import org.cipher.caesar.io.FileServise;
import org.cipher.caesar.service.CaesarCipher;
import org.cipher.caesar.service.Raner;

import java.nio.file.Files;
import java.nio.file.Path;


import static java.lang.module.ModuleDescriptor.read;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        new Raner().run(args);

    }
}

