package com.stack_questions;

import java.util.Stack;
import java.util.Queue;

public class InfixEvaluation {
    public static void main(String[] args) {
        String infixExpression = "2 + (5 - 3 * 6 / 2)";
        // evaluateExpression(infixExpression);
        evaluateExpressionEasyApproach(infixExpression);
    }

    private static void evaluateExpressionEasyApproach(String infixExpression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String operatingChar = "+-*/";

        for (int i = 0; i < infixExpression.length(); i++) {
            char currentCharacter = infixExpression.charAt(i);
            if (currentCharacter == ' ') {
                continue;
            } else if (currentCharacter == '(') {
                operators.push(currentCharacter);
            } else if (Character.isDigit(currentCharacter)) {
                operands.push(currentCharacter - '0');
            } else if (currentCharacter == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    int value1 = operands.pop();
                    int value2 = operands.pop();
                    char oper = operators.pop();
                    int result = calculateValue(value1, value2, oper);
                    operands.push(result);
                    operators.pop();
                }
            } else if (operatingChar.indexOf(currentCharacter) > -1) {
                while (operators.size() > 0 && operators.peek() != '('
                        && getPrecedence(operators.peek()) < getPrecedence(currentCharacter)) {
                    int value1 = operands.pop();
                    int value2 = operands.pop();
                    char oper = operators.pop();
                    int result = calculateValue(value1, value2, oper);
                    operands.push(result);
                }
                operators.push(currentCharacter);
            }
        }
        System.out.println(operands + "\n" + operators);

        while (operators.size() > 0) {
            int firstNum = operands.pop();
            int secondNum = operands.pop();
            char operatorSym = operators.pop();
            int result = calculateValue(firstNum, secondNum, operatorSym);
            operands.push(result);
        }
        System.out.println(operands + "\n" + operators + "\nResult: " + operands.peek());
    }

    // Basic approach
    public static void evaluateExpression(String infixExpression) {
        String operators = "()+-*/";
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            if (infixExpression.charAt(i) == ' ') {
                continue;
            } else if (operators.indexOf(infixExpression.charAt(i)) > -1) {
                if (infixExpression.charAt(i) == ')') {
                    while (operatorStack.size() > 0 && operatorStack.peek() != '(') {
                        int firstNum = operandStack.pop();
                        int secondNum = operandStack.pop();
                        char operatorSym = operatorStack.pop();
                        int result = calculateValue(firstNum, secondNum, operatorSym);
                        operandStack.push(result);
                    }
                    operatorStack.pop();
                    break;
                } else if (operatorStack.size() > 0 && (infixExpression.charAt(i) == '/'
                        || infixExpression.charAt(i) == '*') && (operatorStack.peek() == '*'
                                || operatorStack.peek() == '/')) {
                    while (operatorStack.size() > 0 && (operatorStack.peek() != '(' && operatorStack.peek() != '+'
                            && operatorStack.peek() != '-')) {
                        int firstNum = operandStack.pop();
                        int secondNum = operandStack.pop();
                        char operatorSym = operatorStack.pop();
                        int result = calculateValue(firstNum, secondNum, operatorSym);
                        operandStack.push(result);
                    }
                } else if (operatorStack.size() > 0 && (infixExpression.charAt(i) == '+'
                        || infixExpression.charAt(i) == '-') && (operatorStack.peek() == '+'
                                || operatorStack.peek() == '-')) {
                    while (operatorStack.size() > 0 && operatorStack.peek() != '(') {
                        int firstNum = operandStack.pop();
                        int secondNum = operandStack.pop();
                        char operatorSym = operatorStack.pop();
                        int result = calculateValue(firstNum, secondNum, operatorSym);
                        operandStack.push(result);
                    }
                }
                operatorStack.push(infixExpression.charAt(i));

            } else {
                System.out.println("Num : " + (infixExpression.charAt(i) - '0'));
                operandStack.push(infixExpression.charAt(i) - '0');
            }
        }
        while (operatorStack.size() > 0) {
            int firstNum = operandStack.pop();
            int secondNum = operandStack.pop();
            char operatorSym = operatorStack.pop();
            int result = calculateValue(firstNum, secondNum, operatorSym);
            operandStack.push(result);
        }
        System.out.println(operandStack + "\n" + operatorStack + "\nResult: " + operandStack.peek());
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
