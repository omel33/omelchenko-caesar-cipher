package org.cipher.caesar.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileServise {
    public void write(String outPutPath, String data){

        try {
            Files.write(Path.of(outPutPath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> readLines(String path){
        List<String> lines = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            StringBuilder decryptedContent = new StringBuilder();
            while (fileReader.ready()) {
                lines.add(fileReader.readLine());
            }
            System.out.println(decryptedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
