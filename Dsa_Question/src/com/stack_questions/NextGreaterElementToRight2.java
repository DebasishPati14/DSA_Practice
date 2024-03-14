package com.stack_questions;

import java.util.Stack;

public class NextGreaterElementToRight2 {
    public static void main(String[] args) {
        int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        // int[] arrayElements = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] resultArray = nextGreaterEleToRightAlternate(arrayElements);
        for (int integer : resultArray) {
            System.out.print(integer + "  ");
        }
    }

    static int[] nextGreaterEleToRightAlternate(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for (int i = 1; i < arrayElements.length; i++) {
            while (stack.size() > 0 && arrayElements[stack.peek()] < arrayElements[i]) {
                int poppedIndex = stack.pop();
                resultArray[poppedIndex] = arrayElements[i];
            }
            stack.push(i);
        }
        for (Integer integer : stack) {
            resultArray[integer] = -1;
        }
        return resultArray;
    }

}
