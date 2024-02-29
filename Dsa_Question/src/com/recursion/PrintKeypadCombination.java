package com.recursion;

import java.util.ArrayList;

public class PrintKeypadCombination {
    public static final String[] KEYPAD_VALUES = {
            ". ;",
            "',", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz",

    };

    public static void main(String[] args) {
        String keyPressed = "25274";

        printKeypadCombinationString(keyPressed, "");

    }

    static void printKeypadCombinationString(String keyPressed, String fallbackString) {
        if (keyPressed == "") {
            System.out.print(fallbackString + ", ");
            return;
        }
        char endChar = keyPressed.charAt(0);
        keyPressed = keyPressed.substring(1);

        for (int idx = 0; idx < KEYPAD_VALUES[endChar - '0'].length(); idx++) {
            char eachChar = KEYPAD_VALUES[endChar - '0'].charAt(idx);
            printKeypadCombinationString(keyPressed, fallbackString + eachChar);
        }
    }
}
