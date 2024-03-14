package com.recursion;

public class PrintPermutations {
    public static void main(String[] args) {
        String mainString = "abc";
        System.out.println(mainString.substring(0, 1) + mainString.substring(2));
        printCharPermutations(mainString, "");
    }

    static void printCharPermutations(String mainString, String fallbackString) {
        if (mainString.length() == 0) {
            System.out.print(fallbackString + ", ");
            return;
        }

        for (int i = 0; i < mainString.length(); i++) {
            char ch = mainString.charAt(i);
            String str = mainString.substring(0, i) + mainString.substring(i + 1);
            printCharPermutations(str, fallbackString + ch);
        }
    }
}
