package com.patterns;

import java.util.Scanner;

public class DiamondPattern {
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		printPattern(length);
		scan.close();
	}
	// public static void main(String[] args) {
	// System.out.println("kjfewk");
	// }

	static void printPattern(int length) {
		int printLeft = length / 2 + 1;
		int printRight = length / 2 + 1;

		for (int row = 1; row <= length; row++) {
			for (int col = 1; col <= length; col++) {
				if (col == printLeft || col == printRight) {
					System.out.print("<" + row + "," + col + ">\t");
				} else {
					System.out.print("\t");
				}
			}
			if (row <= length / 2) {
				printLeft--;
				printRight++;
			} else if (row == length - 1) {
				printLeft = length / 2 + 1;
				printRight = length / 2 + 1;
			} else {
				printLeft++;
				printRight--;
			}
			System.out.println("\n");
		}
	}
}
