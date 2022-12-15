package DSA_Practice.PatternProblems;

import java.util.Scanner;

/*
                 * 
                 *   *
                 *   *   *
     *   *   *   *   *   *  *
                 *   *   *
                 *   *
                 *
 */
public class arrowPatterb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter length: ");
		int length = scan.nextInt();
		int space = length / 2;
		int star = 1;
		for (int row = 1; row <= length; row++) {
			if (row == (length / 2) + 1) {
				for (int i = 1; i <= length; i++) {
					System.out.print("#   ");
					star = length / 2;
				}
			} else {
				for (int i = 0; i < space; i++) {
					System.out.print("    ");
				}
				for (int i = 0; i < star; i++) {
					System.out.print("#   ");
				}
				if (row < length / 2) {
					star++;
				} else {
					star--;
				}
			}
			System.out.println();
		}
		scan.close();
	}
}
