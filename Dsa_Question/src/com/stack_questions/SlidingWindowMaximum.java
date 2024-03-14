package com.stack_questions;

import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] allNumbers = { 2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6 };
        int[] nextGreaterElementsToRight = getNGETR(allNumbers);
        int windowSize = 4;
        getMaximumSliding(allNumbers, nextGreaterElementsToRight, windowSize);
        

    }

    static int[] getNGETR(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arrayElements.length - 1);
        resultArray[arrayElements.length - 1] = arrayElements.length;
        for (int i = arrayElements.length - 1; i >= 0; i--) {
            if (arrayElements[stack.peek()] > arrayElements[i]) {
                resultArray[i] = stack.peek();
                stack.push(i);
            } else {
                while (stack.size() > 0) {
                    if (arrayElements[stack.peek()] > arrayElements[i]) {
                        resultArray[i] = stack.peek();
                        stack.push(i);
                        break;
                    }
                    stack.pop();
                }
                if (stack.size() == 0) {
                    resultArray[i] = arrayElements.length;
                    stack.push(i);
                }
            }
        }
        return resultArray;
    }

    private static void getMaximumSliding(int[] numbers, int[] nextGreaterElementsToRight, int windowSize) {
        int j = 0;
        for (int i = 0; i < numbers.length - windowSize; i++) {
            if (j < i) {
                j = i;
            }
            while (nextGreaterElementsToRight[j] < (i + windowSize)) {
                j = nextGreaterElementsToRight[j];
            }
            System.out.print(numbers[j] + ", ");
        }
        
    }

}
