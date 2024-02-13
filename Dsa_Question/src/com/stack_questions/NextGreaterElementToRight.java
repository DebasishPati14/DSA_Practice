package com.stack_questions;

import java.util.Stack;

public class NextGreaterElementToRight {
    public static void main(String[] args) {
        // int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        int[] arrayElements = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] resultArray = getNGETR(arrayElements);
        for (int integer : resultArray) {
            System.out.print(integer + "  ");
        }
    }

    static int[] getNGETR(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arrayElements[arrayElements.length - 1]);
        resultArray[arrayElements.length - 1] = -1;
        for (int i = arrayElements.length - 1; i >= 0; i--) {
            if (stack.peek() > arrayElements[i]) {
                resultArray[i] = stack.peek();
                stack.push(arrayElements[i]);
            } else {
                while (stack.size() > 0) {
                    if (stack.peek() > arrayElements[i]) {
                        resultArray[i] = stack.peek();
                        stack.push(arrayElements[i]);
                        break;
                    }
                    stack.pop();
                }
                if (stack.size() == 0) {
                    resultArray[i] = -1;
                    stack.push(arrayElements[i]);
                }
            }
        }
        return resultArray;
    }

    static int[] getNGETR2(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(arrayElements[arrayElements.length - 1]);
        resultArray[arrayElements.length - 1] = -1;

        for (int i = arrayElements.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arrayElements[i] > st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                resultArray[i] = -1;
            } else {
                resultArray[i] = st.peek();

            }
            st.push(arrayElements[i]);
        }

        return resultArray;
    }
}
