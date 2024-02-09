package com.patterns;

import java.util.*;
/*
 
#  #  #  #  #  #  # 
               #
            # 
         # 
      #  
   #
#  #  #  #  #  #  # 


*  *  *  *  *  *  * *
*                   *
*                   *
*                   *
*                   *
*                   *
*                   *
*  *  *  *  *  *  * *
 
 */

public class HollowSquarePatternZ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Length: ");
        int length = scan.nextInt();
        patternZ(length);
        System.out.println("\n\n\n");
        hollowSquare(length);
        scan.close();
    }

    static void patternZ(int length) {
        System.out.println("Pattern Z");
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (i == 1 || i + j == length + 1 || i == length) {
                    System.out.print("#\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println("\n");
        }
    }

    static void hollowSquare(int length) {
        System.out.println("Hollow Square");
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (i == 1 || j == 1 || j == length || i == length) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println("\n");
        }
    }
}
