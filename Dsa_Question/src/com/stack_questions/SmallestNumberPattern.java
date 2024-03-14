package com.stack_questions;

import java.util.Stack;

public class SmallestNumberPattern {
    public static void main(String[] args) {
        String givenPattern = "idddidid";
        printSmallestFollowingNumber(givenPattern);
    }

    static void printSmallestFollowingNumber(String givenPattern) {
        Stack<Integer> numberStringStack = new Stack<>();
        int num = 1;
        for (int i = 0; i < givenPattern.length(); i++) {
            char currentCh = givenPattern.charAt(i);

            if (currentCh == 'd') {
                numberStringStack.push(num);
                num++;
            } else {
                numberStringStack.push(num);
                num++;

                while (numberStringStack.size() > 0) {
                    System.out.print(numberStringStack.pop());
                }
            }
        }
        numberStringStack.push(num);
        while (numberStringStack.size() > 0) {
            System.out.print(numberStringStack.pop());
        }
    }
}
