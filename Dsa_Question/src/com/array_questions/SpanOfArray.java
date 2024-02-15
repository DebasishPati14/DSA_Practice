package com.array_questions;

import java.util.LinkedList;
import java.util.Scanner;

public class SpanOfArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter size of array: ");
		int sizeOfArray = scan.nextInt();
		System.out.printf("Enter elements of array: ");
		int[] arrayOfInt = getArrayInputs(sizeOfArray);
		int span = getSpanOfArray(arrayOfInt);
		System.out.printf("Span of array is: %d", span);
		scan.close();
	}

	private static int getSpanOfArray(int[] arrayOfInt) {
		int smallestInt = 0;
		int largestElement = 0;

		for (int i = 0; i < arrayOfInt.length; i++) {
			smallestInt = arrayOfInt[i] < smallestInt ? arrayOfInt[i] : smallestInt;
			largestElement = arrayOfInt[i] > largestElement ? arrayOfInt[i] : largestElement;
		}
		return largestElement - smallestInt;
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
