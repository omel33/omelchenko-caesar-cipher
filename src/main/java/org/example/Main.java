package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("input is incorrect");
            return;
        }
        for (String input:
             args) {
            System.out.println("input is correct"+ input);
        }
    }
}
