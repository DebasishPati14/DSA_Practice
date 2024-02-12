package com.arrayQuestions;

import java.util.Scanner;

/*
 * Constraints No digit should be greater tha 9 of int array
 * input 5 
 * 4 6 1 2 9 
 * input 7
 * 3 2 0 7 1 6  
 * 
 * 
 * 
 * 
 */

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter size of first array: ");
        int sizeOfFirstArray = scan.nextInt();
        int[] firstArrayOfDigits = getArrayInputs(sizeOfFirstArray);
        System.out.printf("Enter size of second array: ");
        int sizeOfSecondArray = scan.nextInt();
        int[] secondArrayOfDigits = getArrayInputs(sizeOfSecondArray);

        int[] sumOfTwoArrays = getSumOFTwoDigitArray2(firstArrayOfDigits, secondArrayOfDigits);

        System.out.print("   ");
        printArrays(firstArrayOfDigits);
        System.out.println("+");
        System.out.print("   ");
        printArrays(secondArrayOfDigits);
        System.out.println("---- ---- ---- ---- ---- ---- ---- ----");
        printArrays(sumOfTwoArrays);

    }

    public static void printArrays(int[] secondArrayOfDigits) {
        for (int i : secondArrayOfDigits) {
            System.out.print("   " + i);
        }
        System.out.println();
    }

    public static int[] getSumOFTwoDigitArray(int[] firstArrayOfDigits, int[] secondArrayOfDigits) {
        int lengthOfBiggerArray = firstArrayOfDigits.length > secondArrayOfDigits.length
                ? firstArrayOfDigits.length
                : secondArrayOfDigits.length;
        int[] sumOfTwoArrays = new int[lengthOfBiggerArray + 1];

        for (int i = firstArrayOfDigits.length - 1, j = secondArrayOfDigits.length - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = (i >= 0 ? firstArrayOfDigits[i] : 0) + (j >= 0 ? secondArrayOfDigits[j] : 0);
            if (sum / 10 != 0) {
                sumOfTwoArrays[lengthOfBiggerArray] += sum % 10;
                sumOfTwoArrays[lengthOfBiggerArray - 1] = sum / 10;
            } else {
                sumOfTwoArrays[lengthOfBiggerArray] += sum;
            }
            lengthOfBiggerArray--;
        }
        return sumOfTwoArrays;
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
