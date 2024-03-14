package com.stack_questions;

import java.util.Scanner;
import java.util.Stack;

public class NGSET_LR {
    public static void main(String[] args) {
        int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Choice: (Smaller/Greater)");
        String choice = scan.nextLine();
        System.out.println("Enter Direction :(Left/Right)");
        String direction = scan.nextLine();

        if (choice.equalsIgnoreCase("smaller")) {
            if (direction.equalsIgnoreCase("right")) {
                getSmallerElementToRight(arrayElements);
            } else if (direction.equalsIgnoreCase("left")) {
                getSmallerElementToLeft(arrayElements);

            } else {
                System.out.println("Wrong Input Direction Type");
            }
        } else if (choice.equalsIgnoreCase("greater")) {
            if (direction.equalsIgnoreCase("right")) {
                getGreaterElementToRight(arrayElements);
            } else if (direction.equalsIgnoreCase("left")) {
                getGreaterElementToLeft(arrayElements);

            } else {
                System.out.println("Wrong Input Direction Type");
            }
        } else {
            System.out.println("Wrong Input Choice Type" +
                    choice.toLowerCase().equalsIgnoreCase("smaller"));
        }
        scan.close();
    }

    static void getGreaterElementToRight(int[] arrayElements) {
        int[] resultArray = new int[arrayElements.length];
        resultArray[arrayElements.length - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arrayElements[arrayElements.length - 1]);
        for (int i = resultArray.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() < arrayElements[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                resultArray[i] = -1;
            } else {
                resultArray[i] = stack.peek();
            }
            stack.push(arrayElements[i]);
        }
        for (Integer integer : resultArray) {
            System.out.print(integer + ", ");
        }
    }

    static void getGreaterElementToLeft(int[] arrayElements) {
        int[] resultsArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<>();
        resultsArray[0] = -1;
        stack.push(arrayElements[0]);

        for (int i = 1; i < resultsArray.length; i++) {
            while (stack.size() > 0 && stack.peek() < arrayElements[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                resultsArray[i] = -1;
            } else {
                resultsArray[i] = stack.peek();
            }
            stack.push(arrayElements[i]);
        }

        for (Integer integer : resultsArray) {
            System.out.print(integer + ", ");
        }
    }

    static void getSmallerElementToLeft(int[] arrayElements) {
        int[] resultsArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<>();
        resultsArray[0] = -1;
        stack.push(arrayElements[0]);

        for (int i = 1; i < resultsArray.length; i++) {
            while (stack.size() > 0 && stack.peek() > arrayElements[i]) {
                stack.pop();
            }

            if (stack.size() == 0) {
                resultsArray[i] = -1;
            } else {
                resultsArray[i] = stack.peek();
            }
            stack.push(arrayElements[i]);
        }
        for (Integer integer : resultsArray) {
            System.out.print(integer + ", ");
        }
    }

    static void getSmallerElementToRight(int[] arrayElements) {
        int[] resultsArray = new int[arrayElements.length];
        Stack<Integer> stack = new Stack<>();
        resultsArray[arrayElements.length - 1] = -1;
        stack.push(arrayElements[arrayElements.length - 1]);

        for (int i = resultsArray.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() > arrayElements[i]) {
                stack.pop();
            }

            if (stack.size() == 0) {
                resultsArray[i] = -1;
            } else {
                resultsArray[i] = stack.peek();
            }
            stack.push(arrayElements[i]);
        }
        for (Integer integer : resultsArray) {
            System.out.print(integer + ", ");
        }
    }
}
