package com.recursion;

public class PrintStairPaths {
    public static void main(String[] args) {
        String str = "";
        int currentStairNumber = 5;
        printSubsequence(currentStairNumber, str);
    }

    private static void printSubsequence(int currentStairNumber, String fallbackString) {
        if (currentStairNumber == 0) {
            System.out.println(fallbackString);
            return;
        }
        if (currentStairNumber >= 3) {
            printSubsequence(currentStairNumber - 3, fallbackString + "3");
        }
        if (currentStairNumber >= 2) {
            printSubsequence(currentStairNumber - 2, fallbackString + "2");
        }
        if (currentStairNumber >= 1) {
            printSubsequence(currentStairNumber - 1, fallbackString + "1");
        }
    }
}
