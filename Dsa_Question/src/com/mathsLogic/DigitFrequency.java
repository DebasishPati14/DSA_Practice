package com.mathsLogic;

import java.util.Scanner;

public class DigitFrequency {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number FIrst: ");
		long number = scan.nextLong();

		System.out.println("Enter Digit to Count: ");
		int digit = scan.nextInt();
		scan.close();
		int frequency = 0;

		while (number > 0) {
			if (number % 10 == digit) {
				frequency++;
			}
			number /= 10;
		}

		System.out.printf("Total presence count : %d", frequency);
	}

}
