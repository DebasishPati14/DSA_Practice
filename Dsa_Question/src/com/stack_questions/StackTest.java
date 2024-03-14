package com.stack_questions;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(10);
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.push(20);
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.push(30);
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		int pop = stack.pop();
		System.out.println(stack + "Popped: " + pop + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.push(40);
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.push(50);
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.pop();
		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

		stack.pop();
		stack.pop();

		System.out.println(stack + " => Peek: " + stack.peek() + " Size: " + stack.size());

	}

}
