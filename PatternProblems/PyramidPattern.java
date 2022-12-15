package DSA_Practice.PatternProblems;

import java.util.*;

/*
            *
         *  *  *
      *  *  *  *  *
   *  *  *  *  *  *  *
   
   
   #  #  #  #  #  #  # 
      #  #  #  #  # 
         #  #  #
            #


                * (3,1)
             *  * (2,2)
          *  *  * (1,3)
       *  *  *  * (0,4)
          *  *  *
             *  * 
                * 


       #
       #  # 
       #  #  # 
       #  #  #  # 
       #  #  #  
       #  #  
       #
 */

public class PyramidPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Length: ");
        int length = scan.nextInt();

        originalPattern(length);
        System.out.println("\n\n");
        oppositePattern(length);
        System.out.println("\n\n");

        leftSidePattern(length);
        System.out.println("\n\n");
        rightSidePattern(length);
        scan.close();
    }

    static void originalPattern(int length) {
        System.out.println("Original Side Pyramid\n\n");

        int space = length;
        int star = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*\t");
            }
            star += 2;
            space--;
            System.out.println();
        }

    }

    static void oppositePattern(int length) {
        System.out.println("Opposite Side Pyramid\n\n");
        int space = 0;
        int star = length * 2 - 1;

        for (int i = 1; i <= length * 2 - 1; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("\t#");
            }
            space += 1;
            star -= 2;
            System.out.println();
        }

    }

    static void leftSidePattern(int length) {
        System.out.println("Left Side Pyramid\n\n");
        int space = length - 1;
        int star = 1;
        for (int i = 1; i <= length * 2 - 1; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }
            if (i < length) {
                star++;
                space--;
            } else {
                star--;
                space++;
            }
            System.out.println();
        }
    }

    static void rightSidePattern(int length) {
        System.out.println("Right Side Pyramid\n\n");
        int star = 1;
        for (int i = 1; i <= length * 2 - 1; i++) {
            for (int j = 1; j <= star; j++) {
                System.out.print("#\t");
            }
            if (i < length) {
                star++;
            } else {
                star--;
            }
            System.out.println();
        }
    }
}
