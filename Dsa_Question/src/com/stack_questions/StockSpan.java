package com.stack_questions;

import java.util.Stack;

/*
It's also sun shadow question.

QUESTION
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the prices of a share on n days.
3. You are required to find the stock span for n days.
4. Stock span is defined as the number of days passed between the current day and the first day before today when price was higher than today.
 
e.g. for the array [2, 5, 9, 3, 1, 12, 6, 8, 7]
 --> span for 2 is 1
 --> spa  
 --> span for 9 is 3
 --> span for 3 is 1
 --> span for 1 is 1
 --> span for 12 is 6
 --> span for 6 is 1
 --> span for 8 is 2
 --> span for 7 is 1

 */

public class StockSpan {
    public static void main(String[] args) {
        int[] arrayElements = { 2, 7, 19, 9, 4, 6, 10, 20 };
        // int[] arrayElements = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] resultArray = getStockSpan(arrayElements);
        for (int integer : resultArray) {
            System.out.print(integer + "  ");
        }
        System.out.println();
        getStockSpansSecond(arrayElements);
    }

    static void getStockSpansSecond(int[] arrayElements) {
        int[] resultsArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<>();
        resultsArray[0] = 1;
        stack.push(0);

        for (int i = 1; i < resultsArray.length; i++) {
            if (stack.size() > 0 && arrayElements[stack.peek()] < arrayElements[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                resultsArray[i] = i + 1;
            } else {
                System.out.println("Peak: " + arrayElements[stack.peek()]);
                resultsArray[i] = i - stack.peek();
            }
            stack.push(i);
        }

        for (Integer integer : resultsArray) {
            System.out.print(integer + ", ");
        }
    }

    static int[] getStockSpan(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<Integer>();
        resultArray[0] = 1;
        stack.push(0);

        for (int i = 1; i < resultArray.length; i++) {
            int span = 1;
            int lastPoppedIndex = 0;
            while (stack.size() > 0 && arrayElements[stack.peek()] < arrayElements[i]) {
                lastPoppedIndex = stack.pop();
                span++;
            }

            if (stack.size() > 0) {
                span = arrayElements[i] < arrayElements[stack.peek()] ? span : i + 1;
            } else {
                span = arrayElements[i] < arrayElements[lastPoppedIndex] ? 1 : i + 1;
            }

            resultArray[i] = span;
            stack.push(i);

        }

        return resultArray;
    }
}
