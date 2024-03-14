package com.stack_questions;

import java.util.Stack;

public class MinimumStack {

    public static void main(String[] args) {
        MinStackSpaceConstraint stack = new MinStackSpaceConstraint();
        MinStack minstack = new MinStack();

        System.out.println("Peek: " + stack.peek());
        stack.pop();
        minstack.pop();

        // stack.push(18);

        int[] arrayElements = { 2, 7, 19, 9, -4, 6, 10, 20 };
        for (int i : arrayElements) {
            stack.push(i);
            minstack.push(i);
            ;
        }
        stack.display();
        minstack.display();
        // stack.push(2);
        System.out.println("Pick element: " + stack.peek());
        System.out.println("<MinStack> Pick element: " + minstack.peek());
        // stack.push(31);
        // stack.push(4);
        // stack.push(587);
        stack.display();
        minstack.display();
        System.out.println("Popped element: " + stack.pop());
        System.out.println("<MinStack> Pick element: " + minstack.pop());
        // stack.push(1);
        // stack.push(200);
        stack.display();
        System.out.println("Peek: " + stack.peek() + "Minimum: " + stack.getMinimum());
        System.out.println("<MinStack> Pick element: " + minstack.peek() + "Minimum: " + minstack.getMinimum());

    }

    public static class MinStack {
        Stack<Integer> allData = new Stack<>();
        Stack<Integer> minData = new Stack<>();

        void push(int ele) {
            allData.push(ele);
            if (minData.size() > 0) {
                if (minData.peek() > ele) {
                    minData.push(ele);
                }
            } else {
                minData.push(ele);
            }
        }

        int pop() {
            int poppedEle = -1;
            if (allData.size() > 0) {
                poppedEle = allData.peek();
            } else {
                System.out.println("Stack underflow!");
                return poppedEle;
            }
            if (minData.size() > 0 && minData.peek() == poppedEle) {
                minData.pop();
            }
            return poppedEle;
        }

        int size() {
            return allData.size();
        }

        void display() {
            System.out.println(allData + "Min Stack: " + minData);
        }

        int getMinimum() {
            if (minData.size() > 0) {
                return minData.pop();
            } else {
                System.out.println("Stack underflow!");
                return -1;
            }
        }

        int peek() {
            if (allData.size() > 0) {
                return allData.peek();
            } else {
                System.out.println("Stack underflow!");
                return -1;
            }
        }
    }

    public static class MinStackSpaceConstraint {
        Stack<Integer> allData = new Stack<>();
        int min = 0;

        void push(int ele) {
            if (allData.size() > 0) {
                if (min > ele) {
                    allData.push(ele + (ele - min));
                    min = ele;
                } else {
                    allData.push(ele);

                }
            } else {
                min = ele;
                allData.push(ele);
            }
        }

        int pop() {
            int poppedEle = -1;
            if (allData.size() > 0) {
                poppedEle = allData.pop();
                System.out.println("Min=" + min + "Pop" + poppedEle);
                if (poppedEle < min) {
                    poppedEle = min;
                    min = min + min - poppedEle;
                }
            } else {
                System.out.println("Stack underflow!");
            }
            return poppedEle;
        }

        int size() {
            return allData.size();
        }

        void display() {
            System.out.println(allData);
        }

        int getMinimum() {
            if (allData.size() > 0) {
                return min;
            } else {
                System.out.println("Stack underflow!");
                return -1;
            }
        }

        int peek() {
            if (allData.size() > 0) {
                int peekEle = allData.peek();
                return peekEle < min ? min : peekEle;
            } else {
                System.out.println("Stack underflow!");
                return -1;
            }
        }
    }
}
