package com.stack_questions;

import java.util.Stack;

public class NextSmallerElementToRight {
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
        stack.push(arrayElements[arrayElements.length - 1]);
        resultArray[arrayElements.length - 1] = -1;

        for (int i = resultArray.length - 2; i >= 0; i--) {

            while (stack.size() > 0 && arrayElements[i] < stack.peek()) {
                stack.pop();
            }

            resultArray[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(arrayElements[i]);
        }

        return resultArray;
    }

}
