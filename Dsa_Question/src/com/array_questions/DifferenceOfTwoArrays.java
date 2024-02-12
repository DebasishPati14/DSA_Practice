package com.array_questions;

import java.util.Scanner;

/*
 * ASSUMING THE SECOND ARRAY TO BE GREATER ONE
 */

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter size of first array: ");
        int sizeOfFirstArray = scan.nextInt();
        int[] firstArrayOfDigits = getArrayInputs(sizeOfFirstArray);
        System.out.printf("Enter size of second array: ");
        int sizeOfSecondArray = scan.nextInt();
        int[] secondArrayOfDigits = getArrayInputs(sizeOfSecondArray);

        int[] differenceOfTwoArrays = getDifferenceOfTwoArrays(firstArrayOfDigits, secondArrayOfDigits);

        System.out.print("   ");
        printArrays(firstArrayOfDigits);
        System.out.println("+");
        System.out.print("   ");
        printArrays(secondArrayOfDigits);
        System.out.println("---- ---- ---- ---- ---- ---- ---- ----");
        printArrays(differenceOfTwoArrays);

    }

    public static void printArrays(int[] secondArrayOfDigits) {
        for (int i : secondArrayOfDigits) {
            System.out.print("   " + i);
        }
        System.out.println();
    }

    public static int[] getDifferenceOfTwoArrays(int[] firstArrayOfDigits, int[] secondArrayOfDigits) {
        int lengthOfBiggerArray = firstArrayOfDigits.length > secondArrayOfDigits.length
                ? firstArrayOfDigits.length
                : secondArrayOfDigits.length;
        int[] diffOfTwoArrays = new int[lengthOfBiggerArray];

        for (int i = firstArrayOfDigits.length - 1, j = secondArrayOfDigits.length - 1; i >= 0 || j >= 0; i--, j--) {
            int difference = secondArrayOfDigits[j] - (i >= 0 ? firstArrayOfDigits[i] : 0);
            if (difference < 0) {
                difference = 10 + secondArrayOfDigits[j] - firstArrayOfDigits[i];
                int k = j - 1;
                while (k >= 0) {
                    if (secondArrayOfDigits[k] == 0) {
                        secondArrayOfDigits[k] = 9;
                    } else {
                        secondArrayOfDigits[k] -= 1;
                        break;
                    }
                    k--;
                }
            }
            diffOfTwoArrays[lengthOfBiggerArray - 1] += difference;
            lengthOfBiggerArray--;
        }
        return diffOfTwoArrays;
    }

    static int[] getSumOFTwoDigitArray2(int[] firstArrayOfDigits, int[] secondArrayOfDigits) {
        int[] sumOfTwoArrays = new int[firstArrayOfDigits.length > secondArrayOfDigits.length
                ? firstArrayOfDigits.length + 1
                : secondArrayOfDigits.length + 1];
        int carryOver = 0;
        int sumDigit = 0;

        int firstArrayLength = firstArrayOfDigits.length - 1;
        int secondArrayLength = secondArrayOfDigits.length - 1;
        int resultArraylength = sumOfTwoArrays.length - 1;

        while (resultArraylength >= 0) {
            if (firstArrayLength >= 0) {
                sumDigit += firstArrayOfDigits[firstArrayLength];
            }

            if (secondArrayLength >= 0) {
                sumDigit += secondArrayOfDigits[secondArrayLength];
            }

            carryOver = sumDigit / 10;
            sumOfTwoArrays[resultArraylength] = sumDigit % 10;

            sumDigit /= 10;
            firstArrayLength--;
            secondArrayLength--;
            resultArraylength--;
        }
        sumOfTwoArrays[0] = carryOver;
        return sumOfTwoArrays;
    }

    public static int[] getArrayInputs(int sizeOfArray) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter elements of array: ");
        int[] arrayOfInt = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            arrayOfInt[i] = scan.nextInt();
        }
        return arrayOfInt;
    }
}
