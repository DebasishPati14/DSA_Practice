package com.stack_questions;

import java.util.Stack;

/*
    QUESTION
    1. You are given a number n, representing the size of array a
    2. You are given n numbers, representing the height of bars in a bar chart.
    3. You are required to find and print the area of largest rectangle in the histogram.
 
    e.g 
    for the array [6 254516]>12
 

     Explain
    --------
    2, 5, 4, 5, 1, 6
 */

public class LargestAreaHistogram {
    public static void main(String[] args) {
        // int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        // int[] arrayElements = { 2, 5, 4, 5, 1, 6 };
        int[] arrayElements = { 6, 2, 5, 4, 5, 1, 6 };
        int[] leftNSE = nextSmallerEleToLeft(arrayElements);
        int[] rightNSE = nextSmallerEleToRight(arrayElements);

        int maximumArea = 0;
        for (int i = 0; i < arrayElements.length; i++) {
            int area = arrayElements[i] * (rightNSE[i] - leftNSE[i] - 1);
            if (area > maximumArea) {
                maximumArea = area;
            }
        }

        System.out.println("Maximum area of histogram: " + maximumArea);
    }

    static int[] nextSmallerEleToLeft(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        resultArray[0] = -1;
        for (int i = 1; i < resultArray.length; i++) {
            while (stack.size() > 0 && arrayElements[stack.peek()] > arrayElements[i]) {
                stack.pop();
            }

            if (stack.size() == 0) {
                resultArray[i] = i;
            } else {
                resultArray[i] = stack.peek();
            }

            stack.push(i);
        }

        return resultArray;
    }

    static int[] nextSmallerEleToRight(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arrayElements.length - 1);
        resultArray[arrayElements.length - 1] = arrayElements.length - 1;

        for (int i = arrayElements.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && arrayElements[i] < arrayElements[stack.peek()]) {
                stack.pop();

            }
            if (stack.empty()) {
                resultArray[i] = arrayElements.length - 1;
            } else {
                resultArray[i] = stack.peek();
            }

            stack.push(i);
        }
        return resultArray;
    }
}
