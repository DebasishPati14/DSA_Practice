package DSA_Practice;

import java.util.Scanner;

// hello
public class hollowDiamondPattern {
	public static void main(String[] args) {

		// int size=7;
		// for(int i=0;i<7;i++) {
		// for(int j=0;j<size/2-i;j++) {
		// System.out.print(j);
		// }
		// }
		System.out.println("Enter Length");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int star = length / 2;
		int space = 1;
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= star; j++) {
				System.out.print("*\t");
			}
			for (int j = 1; j <= space; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("*\t");
			}
			if (i <= length / 2) {
				star -= 1;
				space += 2;
			} else {
				star += 1;
				space -= 2;
			}
			System.out.println("\n");
		}

		// for(int i=1;i<5;i++) {
		// for(int j = 1;j<8;j++) {
		// System.out.print("* ");
		//
		// }
		// System.out.println();
		// }
		scan.close();
	}
}

// edw

// * * * * * * (3,1)
// * * * * (2,3)
// * * (1,5)
// (0,7)
// * * (1,5)
// * * * * (2,3)
// * * * * * * (3,1)

// efj
