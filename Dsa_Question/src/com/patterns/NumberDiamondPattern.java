package com.patterns;

import java.util.Scanner;

/*
  
            1
        2   3   2
    3   4   5   4   3
        2   4   2
            1

 */
public class NumberDiamondPattern {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter length: ");
		int length = scan.nextInt();
		// int length = 7;
		int space = length / 2;
		int printingTime = 1;
		int printOutNumber = 0;
		for (int row = 1; row <= length; row++) {

			for (int sp = 1; sp <= space; sp++) {
				System.out.print("\t");
			}

			if (row > length / 2) {
				printOutNumber = (length - row) + 1;
			} else {
				printOutNumber = row;
			}

			for (int print = 1; print <= printingTime; print++) {
				System.out.print(printOutNumber + "\t");
				// if (print == 1) {
				// printOutNumber = row;
				// } else
				if (print <= printingTime / 2) {
					printOutNumber++;
				} else {
					printOutNumber--;
				}
			}

			if (row <= length / 2) {
				space--;
				printingTime += 2;
			} else {
				printingTime -= 2;
				space++;
			}

			System.out.println("\n");
		}
		scan.close();
	}
}
