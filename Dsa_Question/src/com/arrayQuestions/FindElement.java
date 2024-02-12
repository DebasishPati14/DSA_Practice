package com.arrayQuestions;

import java.util.Scanner;

public class FindElement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter size of array: ");
		int sizeOfArray = scan.nextInt();
		System.out.printf("Enter elements of array: ");
		int[] arrayOfInt = getArrayInputs(sizeOfArray);
		System.out.printf("Enter element to find from array: ");
		int element = scan.nextInt();
		int presentIndex = getIndexOfElement(element, arrayOfInt);
		System.out.printf("Element is present at %d", presentIndex, " index.");
	}

	private static int getIndexOfElement(int element, int[] arrayOfInt) {
		int index = -1;
		for (int i = 0; i < arrayOfInt.length; i++) {
			if (element == arrayOfInt[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static int[] getArrayInputs(int sizeOfArray) {
		Scanner scan = new Scanner(System.in);
		int[] arrayOfInt = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arrayOfInt[i] = scan.nextInt();
		}
		return arrayOfInt;
	}

}
