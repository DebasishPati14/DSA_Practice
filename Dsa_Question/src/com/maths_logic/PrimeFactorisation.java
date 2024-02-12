package com.maths_logic;

import java.util.Scanner;

public class PrimeFactorisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 120;
		int factor = 2;
		while (number > 1) {
			if (number % factor == 0) {
				System.out.print(factor + ", ");
				number /= factor;
			} else
				factor++;
		}

		primeFactorisation();
	}

	static void primeFactorisation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scan.nextInt();
		while (number % 2 == 0) {
			System.out.print("2" + ", ");
			number /= 2;

		}
		for (int i = 3; i < Math.sqrt(number); i += 2) {
			while (number % i == 0) {
				System.out.print(i + ", ");
				number /= i;
			}
		}
		if (number > 2) {
			System.out.print(number);
		}
		scan.close();
	}

}
