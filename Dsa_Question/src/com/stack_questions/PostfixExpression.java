package com.stack_questions;

import java.util.Stack;

public class PostfixExpression {
    static final String operators = "+-*/";

    public static void main(String[] args) {
        String postfixExpression = "264*8/+3-";
        getInfixPrefixExpression(postfixExpression);
    }

    public static void getInfixPrefixExpression(String postfixExpression) {
        Stack<String> infixExpression = new Stack<String>();
        Stack<String> prefixExpression = new Stack<String>();
        Stack<Integer> postfixValueStack = new Stack<Integer>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char currentCh = postfixExpression.charAt(i);

            if (operators.indexOf(currentCh) > -1) {
                String infixValue2 = infixExpression.pop();
                String infixValue1 = infixExpression.pop();
                String resultInfixValue = "(" + infixValue1 + currentCh + infixValue2 + ")";
                infixExpression.push(resultInfixValue);

                String prefixValue2 = prefixExpression.pop();
                String prefixValue1 = prefixExpression.pop();
                String resultPrefixValue = currentCh + prefixValue1 + prefixValue2;
                prefixExpression.push(resultPrefixValue);

                Integer postfixValue2 = postfixValueStack.pop();
                Integer postfixValue1 = postfixValueStack.pop();
                Integer resultPostfixValue = calculateValue(postfixValue1, postfixValue2, currentCh);
                postfixValueStack.push(resultPostfixValue);
            } else {
                infixExpression.push(currentCh + "");
                prefixExpression.push(currentCh + "");
                postfixValueStack.push(currentCh - '0');
            }
            System.out.println(infixExpression.peek());
            System.out.println(prefixExpression.peek());
            System.out.println(postfixValueStack.peek());
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
