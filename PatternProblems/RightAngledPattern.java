package DSA_Practice.PatternProblems;

import java.util.Scanner;

/*
    
    *
    *  *
    *  *  *
    *  *  *  *
    *  *  *  *  *

    
                #
             #  #
          #  #  #
       #  #  #  #
    #  #  #  #  #


    *  *  *  *  *
    *  *  *  *
    *  *  *
    *  *
    *

    #  #  #  #  #
       #  #  #  #
          #  #  #
             #  #
                #
*/

public class RightAngledPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int length = scan.nextInt();

        originalSidePattern(length);

        System.out.println();
        System.out.println();

        oppositeSidePattern(length);

        System.out.println();
        System.out.println();

        upsideDownOriginalSidePattern(length);

        System.out.println();
        System.out.println();

        upsideDownOppositeSidePattern(length);
        scan.close();
    }

    static void originalSidePattern(int length) {
        System.out.println("\n Original Side Pattern");

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    static void oppositeSidePattern(int length) {
        System.out.println("\n Opposite Side Pattern");

        for (int i = 1; i <= length; i++) {
            for (int j = length - 1; j >= i; j--) {
                System.out.print("\t");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#\t");
            }
            System.out.println();
        }
    }

    static void upsideDownOriginalSidePattern(int length) {
        System.out.println("\n Upside Down Original Side Pattern");
        for (int i = length; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    static void upsideDownOppositeSidePattern(int length) {
        System.out.println();
        System.out.println("Upside Down Opposite Side Pattern");

        for (int i = length; i >= 1; i--) {
            for (int j = 0; j < length - i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#\t");
            }
            System.out.println();
        }
    }
}
