package com.maths_logic;

import java.util.Arrays;
import java.util.Scanner;

public class KaprekersConstant {
	public static void main(String[] args) {
		System.out.println("Enter any 4 digit number:");
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();

		int sortedNumber[] = sortNumber(inputNumber);
		int difference = 0;
		int iterationCount = 0;

		while (iterationCount < 7 && difference != 6174) {
			difference = Math.abs(sortedNumber[0] - sortedNumber[1]);
			iterationCount++;
			System.out
					.println("\n\n\nAscending: " + sortedNumber[0] + "\niteration: " + iterationCount + "\nDescending: "
							+ sortedNumber[1] + "\nDifference: " + difference);
			sortedNumber = sortNumber(difference);
		}

		scan.close();
	}

	public static int[] sortNumber(int inputNumber) {
		String number = Integer.toString(inputNumber);
		char inputCharacters[] = number.toCharArray();
		Arrays.sort(inputCharacters);
		int ascendingSortNumber = Integer.parseInt(new String(inputCharacters));
		int descendingSortNumber = 0;
		int ascendingSortNumberCopy = ascendingSortNumber;
		int iteration = 3;
		while (ascendingSortNumberCopy > 0) {
			int digit = ascendingSortNumberCopy % 10;
			descendingSortNumber += (int) (digit * Math.pow(10, iteration));
			iteration--;
			ascendingSortNumberCopy /= 10;
		}
		int sortedNumbers[] = { ascendingSortNumber, descendingSortNumber };
		return sortedNumbers;
	}

	public static int descendingSort(String number) {
		char inputCharacters[] = number.toCharArray();
		Arrays.sort(inputCharacters);
		return Integer.parseInt(new String(inputCharacters));
	}
}
