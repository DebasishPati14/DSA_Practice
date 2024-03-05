package com.patterns;

import java.util.Scanner;

public class SwastikPattern {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = 0;
		while (length % 2 != 1) {
			System.out.print("Enter Length(Must be odd): ");
			length = scan.nextInt();
		}

		for (int row = 1; row <= length; row++) {
			for (int col = 1; col <= length; col++) {
				if ((row == length / 2 + 1) || (col == length / 2 + 1)) {
					System.out.print("  #*#  ");
				} else if ((row == 1 && col < length / 2 + 1) || (row == length && col > length / 2)
						|| (col == 1 && row > length / 2) || (col == length && row < length / 2 + 1)) {
					System.out.print("  #*#  ");
				} else {
					System.out.print("       ");
				}
			}
			System.out.println("\n");
		}
		scan.close();
	}

}
