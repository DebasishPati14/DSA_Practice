package com.patterns;

import java.util.Scanner;

/*
 
   @      @      @      @      @      @      @      @      @      @      @   

          @                                                @   

                 @                                    @   

                        @                        @   

                               @            @   

                                      @   

                               @      @      @   

                        @      @      @      @      @   

                 @      @      @      @      @      @      @   

          @      @      @      @      @      @      @      @      @   

   @      @      @      @      @      @      @      @      @      @      @   


 */
public class HourGlassPattern {
	public static void main(String[] args) {
		System.out.print("Enter Length: ");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int star = length;
		int space = 0;
		int[] innerStar = { 0, length - 1 };
		for (int row = 1; row <= length; row++) {
			for (int i = 1; i <= space; i++) {
				System.out.print("       ");
			}
			for (int i = 1; i <= star; i++) {
				if (row > length / 2 || row == 1) {
					System.out.print("   @   ");
				} else if (row != 1) {
					if (i == 1 || i == star)
						System.out.print("   @   ");
					else
						System.out.print("      ");
				}
			}
			if (row <= length / 2) {
				space++;
				star -= 2;
				innerStar[0] += 1;
				innerStar[1] -= 1;
			} else {
				space--;
				star += 2;
			}
			System.out.println("\n");
		}
		scan.close();
	}
}
