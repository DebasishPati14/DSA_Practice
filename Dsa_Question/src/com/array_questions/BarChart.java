package com.array_questions;

import java.util.Scanner;

/*
 *
 * input 5
 * 5 7 2 0 4
 * 
 * Output
 *       #
 *       #
 *     # #     
 *     # #     # 
 *     # #     # 
 *     # # #   # 
 *     # # #   # 
 * 
*/
public class BarChart {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter size of array: ");
        int sizeOfArray = scan.nextInt();
        System.out.printf("Enter elements of array: ");
        int[] arrayOfInt = getArrayInputs(sizeOfArray);
        printBarChartOFArray(arrayOfInt);
    }

    private static void printBarChartOFArray(int[] arrayOfInt) {
        int noOfRow = 0;// row is the maximum element of array
        for (int number : arrayOfInt) {
            noOfRow = number > noOfRow ? number : noOfRow;
        }
        for (int row = 0; row < noOfRow; row++) {
            for (int col = 0; col < arrayOfInt.length; col++) {
                if (arrayOfInt[col] >= noOfRow - row) {
                    System.out.print("%\t");
                } else {
                    System.out.print("_\t");
                }
            }
            System.err.println();
        }

    }

    private static int[] getArrayInputs(int sizeOfArray) {
        Scanner scan = new Scanner(System.in);
        int[] arrayOfInt = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            arrayOfInt[i] = scan.nextInt();
        }
        return arrayOfInt;
    }
}
