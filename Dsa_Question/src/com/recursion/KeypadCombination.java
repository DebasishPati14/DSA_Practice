package com.recursion;

import java.util.ArrayList;

/*

1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone,
 
2. The following list is the key to characters map
 
0-> . ;
1-> a b c 
2-> d e f 
3-> g h i 
4-> j k l 
5-> m n o 
6-> p q r s 
7-> t u 
8-> v w x 
9-> y z
 
3. Complete the body of getKPC function without changing signature to get the list of all words that could be produced by the keys in str.
 
Use sample input and output to take idea about output.
 
 */

public class KeypadCombination {

    public static final String[] KEYPAD_VALUES = {
            ".;",
            "',", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz",

    };

    public static void main(String[] args) {
        String keyPressed = "25274";

        ArrayList<String> keyPressedStrings1 = getCombineTwoList(keyPressed);

        System.out.println(keyPressedStrings1);

    }

    static ArrayList<String> getCombineTwoList(String str) {
        if (str.length() == 0) {
            ArrayList<String> strList = new ArrayList<>();
            strList.add("");
            return strList;
        }

        char currentNumber = str.charAt(0);
        str = str.substring(1);

        ArrayList<String> prevResultString = getCombineTwoList(str);
        ArrayList<String> finalResultStrings = new ArrayList<>();

        for (int i = 0; i < KEYPAD_VALUES[currentNumber - '0'].length(); i++) {
            char ch = KEYPAD_VALUES[currentNumber - '0'].charAt(i);
            for (String prevStr : prevResultString) {
                finalResultStrings.add(ch + prevStr);
            }
        }

        return finalResultStrings;
    }

}
