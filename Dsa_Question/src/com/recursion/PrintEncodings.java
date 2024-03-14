package com.recursion;

public class PrintEncodings {
    public static void main(String[] args) {
        int keyPressed = 123456;
        printEncodings(keyPressed, "");
    }

    // a=97, z=122
    static void printEncodings(int keyPressed, String encodedStr) {
        if (keyPressed == 0) {
            System.out.println(encodedStr);
            return;
        }
        int bigDigit = keyPressed % 100;
        int smallDigit = keyPressed % 10;
        char smallCh = (char) (smallDigit + 96);
        char bigCh = (char) (bigDigit + 96);
        printEncodings(keyPressed / 10, smallCh + encodedStr);
        if (bigDigit + 96 < 122 && bigDigit + 96 > 106) {
            printEncodings(keyPressed / 100, bigCh + encodedStr);
        }
    }

}
