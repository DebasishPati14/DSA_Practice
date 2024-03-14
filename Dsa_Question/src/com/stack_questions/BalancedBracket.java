package com.stack_questions;

import java.util.Scanner;
import java.util.Stack;

/*
* [(a+b)+{(c+d)*(e/f)}] -> true
* [(a+b)+{(c+d)*(e/f)]} -> false
* [(a+b)+((c+d)*(e/f)]  -> false
* (((a+b)+(c+d)*(e/f)]] -> false
*/

public class BalancedBracket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a valid expression: ");
        String expression = scan.nextLine();
        boolean isBalancedExpression = checkBalancedBracket2(expression);
        if (isBalancedExpression) {
            System.out.println("Does not contain any unbalanced bracket. Good Expression");
        } else {
            System.out.println("Contains unbalanced bracket. Bad Expression.");
        }
        scan.close();
    }

    private static boolean checkBalancedBracket2(String expression) {
        boolean isBalanced = true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() == 0) {
                    isBalanced = false;
                    break;
                } else if (stack.peek() != '(') {
                    isBalanced = false;
                    break;
                } else {
                    System.out.println(stack);
                    stack.pop();
                }
            } else if (ch == '}') {
                if (stack.size() == 0) {
                    isBalanced = false;
                    break;
                } else if (stack.peek() != '{') {
                    isBalanced = false;
                    break;
                } else {
                    System.out.println(stack);
                    stack.pop();
                }
            } else if (ch == ']') {
                if (stack.size() == 0) {
                    isBalanced = false;
                    break;
                } else if (stack.peek() != '[') {
                    isBalanced = false;
                    break;
                } else {
                    System.out.println(stack);
                    stack.pop();
                }
            }
        }
        if (stack.size() > 0) {
            isBalanced = false;
        }

        return isBalanced;
    }

    private static boolean checkBalancedBracket(String expression) {
        boolean isBalanced = true;
        Stack<Character> stack = new Stack<Character>();
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == ')' || ch == '}' || ch == ']') {
                    while (stack.peek() != (ch == ')' ? '(' : ch == ']' ? '[' : '{')) {
                        stack.pop();
                    }
                    stack.pop();
                    System.out.println(stack);
                } else {
                    stack.push(ch);
                    System.out.println(stack);
                }
            }
        } catch (Exception e) {
            isBalanced = false;
        }
        if (stack.size() != 0) {
            isBalanced = false;
        }
        return isBalanced;
    }
}
