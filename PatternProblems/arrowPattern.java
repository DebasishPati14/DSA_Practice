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
public class arrowPattern {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter length: ");
		int length = scan.nextInt();
		System.out.println("\n-------------\nArrow Pattern\n-------------");
		printArrow(length);
		System.out.println("\n-------------\nPalm Tree\n-------------");
		printPalmTree(length);
		scan.close();
	}

	private static void printPalmTree(int length) {
		int space = length / 2;
		int star = 1;
		for (int row = 1; row <= length; row++) {
			for (int sp = 1; sp <= space; sp++) {
				System.out.print("\t");
			}
			for (int st = 1; st <= star; st++) {
				System.out.print("*\t");
			}
			if (row <= length / 2) {
				star += 2;
				space--;
			} else {
				star = 1;
				space = length / 2;
			}
			System.out.println("\n");
		}
	}

	private static void printArrow(int length) {
		int space = length / 2;
		int star = 1;
		for (int row = 1; row <= length; row++) {
			if (row == (length / 2) + 1) {
				for (int i = 1; i <= length; i++) {
					System.out.print("# \t ");
					star = length / 2;
				}
			} else {
				for (int i = 0; i < space; i++) {
					System.out.print("  \t ");
				}
				for (int i = 0; i < star; i++) {
					System.out.print("# \t ");
				}
				if (row < length / 2) {
					star++;
				} else {
					star--;
				}
			}
			System.out.println("\n");
		}

	}
}
