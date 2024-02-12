package com.maths_logic;

import java.util.Scanner;

public class PythagorinTriplet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter three numbers separated by space: ");
		String str = scan.nextLine();
		String threeStringNumbers[] = str.split(" ", 5);
		int num1 = Integer.parseInt(threeStringNumbers[0]);
		int num2 = Integer.parseInt(threeStringNumbers[1]);
		int num3 = Integer.parseInt(threeStringNumbers[2]);

		if (num2 * num2 == num1 * num1 + num3 * num3 || num2 * num2 == Math.abs(num1 * num1 - num3 * num3))
			System.out.println("Yes! It's a pythagorian triplet");
		else
			System.out.println("No! It's not a pythagorian triplet");
		scan.close();
	}

}
