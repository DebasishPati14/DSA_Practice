package com.stack_questions;

import java.util.Stack;

public class NextGreaterElementToLeft {
    public static void main(String[] args) {
        // int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        int[] arrayElements = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] resultArray = getNSETR(arrayElements);
        for (int integer : resultArray) {
            System.out.print(integer + "  ");
        }
    }

    static int[] getNSETR(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arrayElements[0]);
        resultArray[0] = -1;

        for (int i = 1; i < resultArray.length; i++) {
            while (stack.size() > 0 && stack.peek() < arrayElements[i]) {
                stack.pop();
            }

            resultArray[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(arrayElements[i]);
        }

        return resultArray;
    }
}
