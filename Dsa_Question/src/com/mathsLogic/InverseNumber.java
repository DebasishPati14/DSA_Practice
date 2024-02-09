package com.mathsLogic;

import java.util.Scanner;

public class InverseNumber {

	public static void main(String[] args) {

		/*
		 * USING CHAR ARRAY
		 * 
		 * char number[] = "31542".toCharArray(); int answer[] = new int[number.length];
		 * String str = new String(""); for (int i = 0; i < number.length; i++) { str =
		 * String.valueOf(number[i]); answer[Integer.parseInt(str, 10) - 1] = i + 1; }
		 * for (int ch : answer) { System.out.print(ch + " "); }
		 * 
		 */
		int number = 81456273;
		int copy = number;
		int numberLength = 0;
		int answer = 0;
		while (copy > 0) {
			numberLength++;
			copy /= 10;
		}

		int remainder = 0;
		for (int i = 1; i < numberLength + 1; i++) {
			remainder = number % 10;
			answer = answer + (int) Math.pow(10, remainder - 1) * i;
			number /= 10;
		}
		System.out.println(answer);

		customisedInverseNumber();
	}

	static void customisedInverseNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number You want to reverse: - ");
		int number = scan.nextInt();
		int copy = number;
		int numberLength = 0;
		int answer = 0;
		while (copy > 0) {
			copy /= 10;
			numberLength++;
		}

		for (int i = 1; i <= numberLength; i++) {
			answer = answer + (int) Math.pow(10, (number % 10) - 1) * i;
			number /= 10;
		}
		System.out.println("The result is : " + answer);
		scan.close();
	}

}
