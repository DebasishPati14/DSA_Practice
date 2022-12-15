package DSA_Practice.PatternProblems;

//     *        (2,1) 
//   * * *      (1,3)
// * * * * *    (0,5)
//   * * *      (1,3)
//     *        (2,1)
import java.util.Scanner;

public class solidDiamondPattern {

	public static void bluePrint(int length) {
		int space = length / 2;
		int step = 1;
		for (int i = 1; i <= length; i++) {
			System.out.println("(" + space + "," + step + ")");
			if (i <= length / 2) {
				space--;
				step += 2;
			} else {
				space++;
				step -= 2;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter any odd number");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int space = length / 2;
		int step = 1;
		bluePrint(length);
		for (int i = 1; i <= length; i++) {
			for (int x = 1; x <= space; x++) {
				System.out.print("\t");
			}
			for (int x = 1; x <= step; x++) {
				System.out.print("*\t");
			}
			// System.out.print("* ");
			// System.out.println("("+space+","+step+")");
			if (i <= length / 2) {
				space--;
				step += 2;
			} else {
				space++;
				step -= 2;
			}
			System.out.println("\n");
		}
		scan.close();
	}

}
