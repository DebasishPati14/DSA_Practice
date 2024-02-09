package com.patterns;

import java.util.Scanner;

/*
 
     1                                                  13
     1   2                                         12   13
     1   2   3                                11   12   13
     1   2   3   4                       10   11   12   13
     1   2   3   4   5               9   10   11   12   13
     1   2   3   4   5   6       8   9   10   11   12   13
     1   2   3   4   5   6   7   8   9   10   11   12   13


     1                      1
     1   2              2   1
     1   2   3      3   2   1
     1   2   3   4  3   2   1

 */
public class PatternVwithNumber {
       public static void main(String[] args) {
              Scanner scan = new Scanner(System.in);
              System.out.print("Length: ");
              int length = scan.nextInt();
              // for (int row = 1; row <= length; row++) {
              // for (int col = 1; col <= (length * 2) - 1; col++) {
              // if (col <= length) {
              // printOutNumber = col;
              // } else {
              // printOutNumber = length * 2 - col;
              // }
              // System.out.print(printOutNumber + "\t");
              // }
              // System.out.println();
              // }
              printPattern(length);
              scan.close();
       }

       public static void printPattern(int length) {
              int space = length * 2 - 3;
              int printTime = 1;
              for (int row = 1; row <= length; row++) {
                     for (int i = 1; i <= printTime; i++) {
                            System.out.print(i + "\t");
                     }
                     for (int i = 0; i < space; i++) {
                            System.out.print("\t");
                     }
                     for (int i = printTime; i >= 1; i--) {
                            if (i != length)
                                   System.out.print(i + "\t");
                     }
                     printTime++;
                     space -= 2;
                     System.out.println();
              }
       }
}
