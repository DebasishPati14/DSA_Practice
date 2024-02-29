package com.recursion;

public class PrintSubSequence {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwx";
        printSubsequence(str, "");
    }

    private static void printSubsequence(String mainString, String fallbackString) {
        if (mainString == "") {
            System.out.print(fallbackString + ", ");
            return;
        }

        char ch = mainString.charAt(0);
        mainString = mainString.substring(1);

        printSubsequence(mainString, fallbackString + ch);
        printSubsequence(mainString, fallbackString + "");
    }
}
