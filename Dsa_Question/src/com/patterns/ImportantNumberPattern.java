package com.patterns;

/*
  1 
  1   1 
  1   2   1 
  1   3   3   1
  1   4   6   4    1 
  1   5   10  10   5   1
 */
import java.util.Scanner;

public class ImportantNumberPattern {
	public static void main(String[] args) {
		System.out.print("Enter Length: ");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int result = 0;

		for (int row = 0; row <= length; row++) {
			// number = row;
			for (int col = 0; col <= row; col++) {

				result = multiplyUpto(row) / (multiplyUpto(col) * multiplyUpto(row - col));

				System.out.print(result + "\t");
			}
			System.out.println("\n");
		}
		scan.close();
	}

	public static int multiplyUpto(int number) {
		int answer = 1;
		for (int i = 1; i <= number; i++) {
			answer *= i;
		}
		return answer;
	}
}
