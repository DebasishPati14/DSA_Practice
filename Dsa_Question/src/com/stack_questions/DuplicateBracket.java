package com.stack_questions;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBracket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a valid expression: ");
        String expression = scan.nextLine();
        boolean isValidExpression = checkDuplicateBracket(expression);
        if (isValidExpression) {
            System.out.println("Does not contain any duplicate bracket. Good Expression");
        } else {
            System.out.println("Contains duplicate bracket. Bad Expression.");
        }
        scan.close();
    }

    private static boolean checkDuplicateBracket(String expression) {
        boolean isDuplicate = true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ')') {
                boolean hasAnyElement = false;
                while (stack.peek() != '(') {
                    hasAnyElement = true;
                    stack.pop();
                }
                char lastPoppedCharacter = stack.pop();
                if (lastPoppedCharacter == '(' && !hasAnyElement) {
                    isDuplicate = false;
                    break;
                }
                System.out.println("\n" + stack + "\n");
                /*
                 * EASY SOLUTION
                 * -----------------------
                 * if (expression.charAt(i) == ')') {
                 * if(stack.peek='('){
                 * isDuplicate = false;
                 * break;
                 * }
                 * }else{
                 * while (stack.peek() != '(') {
                 * hasAnyElement = true;
                 * stack.pop();
                 * }
                 * }
                 * 
                 */
            } else {
                stack.push(expression.charAt(i));
            }
            System.out.println(stack);
        }
        return isDuplicate;
    }
}
