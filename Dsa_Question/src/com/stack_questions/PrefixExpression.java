package com.stack_questions;

import java.util.Stack;

public class PrefixExpression {
    public static void main(String[] args) {
        String prefixExpression = "-+2/*6483";
        evaluateExpression(prefixExpression);
    }

    public static void evaluateExpression(String prefixExpression) {
        Stack<String> postfixExpressionStack = new Stack<>();
        Stack<String> infixExpressionStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        String allOperators = "+-*/";

        for (int i = prefixExpression.length() - 1; i >= 0; i--) {
            char currentChar = prefixExpression.charAt(i);
            if (allOperators.indexOf(currentChar) > -1) {
                // Infix Valuation
                String infixValue1 = infixExpressionStack.pop();
                String infixValue2 = infixExpressionStack.pop();

                String newInfixValue = "(" + infixValue1 + currentChar + infixValue2 + ")";
                infixExpressionStack.push(newInfixValue);

                // Postfix Valuation
                String postfixValue1 = postfixExpressionStack.pop();
                String postfixValue2 = postfixExpressionStack.pop();

                String newPostfixValue = postfixValue1 + postfixValue2 + currentChar;
                postfixExpressionStack.push(newPostfixValue);

                // Valuating Operation
                // Postfix Valuation
                int value1 = valueStack.pop();
                int value2 = valueStack.pop();

                int newValue = calculateValue(value1, value2, currentChar);
                valueStack.push(newValue);
            } else {
                infixExpressionStack.push(currentChar + "");
                postfixExpressionStack.push(currentChar + "");
                valueStack.push(currentChar - '0');
            }
        }

        System.out.println("Infix Exp:->" + infixExpressionStack.peek());
        System.out.println("Postfix Exp:->" + postfixExpressionStack.peek());
        System.out.println("Value Exp:->" + valueStack.peek());
    }

    static int getPrecedence(char opr) {
        if (opr == '+' || opr == '-') {
            return 1;
        } else if (opr == '*' || opr == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int calculateValue(int firstNum, int secondNum, char operatorSym) {
        int result = 0;
        if (operatorSym == '+') {
            result = firstNum + secondNum;
        } else if (operatorSym == '-') {
            result = secondNum - firstNum;
        } else if (operatorSym == '*') {
            result = firstNum * secondNum;
        } else if (operatorSym == '/') {
            result = secondNum / firstNum;
        }
        return result;
    }
}
