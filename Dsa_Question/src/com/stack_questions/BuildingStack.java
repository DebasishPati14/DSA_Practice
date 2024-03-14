package com.stack_questions;

public class BuildingStack {
    public static void main(String[] args) {
        int size = 5;
        CustomStack stack = new CustomStack(size);

        System.out.println("Peek: " + stack.peeek());
        stack.pop();
        stack.push(1);
        stack.display();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("Popped element: " + stack.pop());
        stack.push(1);
        stack.push(2);
        stack.display();
        System.out.println("Peek: " + stack.peeek());

    }

    public static class CustomStack {
        private int[] data;
        private int topOfStack;

        CustomStack(int capacity) {
            this.data = new int[capacity];
            topOfStack = -1;
        }

        void push(int element) {
            if (topOfStack >= this.data.length - 1) {
                int[] newArr = new int[2 * this.data.length];
                for (int i = 0; i < this.data.length; i++) {
                    newArr[i] = this.data[i];
                }
                this.data = newArr;
                topOfStack++;
                data[topOfStack] = element;
            } else {
                topOfStack++;
                this.data[topOfStack] = element;
            }

        }


        int pop() {
            if (topOfStack == -1) {
                System.out.println("Stack Underflow Error");
                return -1;
            } else {
                return this.data[topOfStack--];
            }
        }

        int size() {
            return topOfStack + 1;
        }

        int peeek() {
            if (topOfStack == -1) {
                System.out.println("Stack Underflow Error");
                return -1;
            } else {
                return this.data[topOfStack];
            }
        }

        void display() {
            for (int num : this.data) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
