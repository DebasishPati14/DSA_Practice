package com.stack_questions;

import java.util.Stack;

public class PrefixPostfixConversion {

    public static void main(String[] args) {
        String infixExpression = "(A+B) * (C-D) ";
        // evaluateExpression(infixExpression);
        evaluateExpressionEasyApproach(infixExpression);
    }

    private static void evaluateExpressionEasyApproach(String infixExpression) {
        Stack<String> prefixOperands = new Stack<>();
        Stack<String> postfixOperands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String operatingChar = "+-*/";

        for (int i = 0; i < infixExpression.length(); i++) {
            char currentCharacter = infixExpression.charAt(i);
            if (currentCharacter == ' ') {
                continue;
            } else if (currentCharacter == '(') {
                operators.push(currentCharacter);
            } else if (currentCharacter != ')' && operatingChar.indexOf(currentCharacter) == -1) {
                prefixOperands.push(currentCharacter + "");
                postfixOperands.push(currentCharacter + "");
            } else if (currentCharacter == ')') {
                while (operators.peek() != '(') {
                    char currentOperator = operators.pop();

                    String prefixValue2 = prefixOperands.pop();
                    String prefixValue1 = prefixOperands.pop();
                    String newPrefixResult = currentOperator + prefixValue1 + prefixValue2;
                    prefixOperands.push(newPrefixResult);

                    String postfixValue2 = postfixOperands.pop();
                    String postfixValue1 = postfixOperands.pop();
                    String newPostfixResult = postfixValue1 + postfixValue2 + currentOperator;
                    postfixOperands.push(newPostfixResult);
                }
                operators.pop();
            } else if (operatingChar.indexOf(currentCharacter) > -1) {
                if (operators.size() > 0 && getPrecedence(operators.peek()) > getPrecedence(currentCharacter)) {
                    char currentOperator = operators.pop();

                    String prefixValue2 = prefixOperands.pop();
                    String prefixValue1 = prefixOperands.pop();
                    String newPrefixResult = currentOperator + prefixValue1 + prefixValue2;
                    prefixOperands.push(newPrefixResult);

                    String postfixValue2 = postfixOperands.pop();
                    String postfixValue1 = postfixOperands.pop();
                    String newPostfixResult = postfixValue1 + postfixValue2 + currentOperator;
                    postfixOperands.push(newPostfixResult);
                }
                operators.push(currentCharacter);
            }
        }
        System.out.println(prefixOperands + "\n");

        while (operators.size() > 0) {
            char currentOperator = operators.pop();

            String prefixValue2 = prefixOperands.pop();
            String prefixValue1 = prefixOperands.pop();
            String newPrefixResult = currentOperator + prefixValue1 + prefixValue2;
            System.out.println("Prefix: " + newPrefixResult);
            prefixOperands.push(newPrefixResult);

            String postfixValue2 = postfixOperands.pop();
            String postfixValue1 = postfixOperands.pop();
            String newPostfixResult = postfixValue1 + postfixValue2 + currentOperator;
            System.out.println("Postfix: " + newPostfixResult);
            postfixOperands.push(newPostfixResult);
        }
        System.out.println(
                "\nPREResult: " + prefixOperands.peek() + "\n" + operators + "\nPOSTResult: " + postfixOperands.peek());
    }

    public static int getPrecedence(char operatorSymbol) {
        int result = 0;
        if (operatorSymbol == '+') {
            result = 1;
        } else if (operatorSymbol == '-') {
            result = 1;
        } else if (operatorSymbol == '*') {
            result = 2;
        } else if (operatorSymbol == '/') {
            result = 2;
        }
        return result;
    }

}
