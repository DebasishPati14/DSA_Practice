package com.mathsLogic;

import java.util.Scanner;

public class AnyBaseMultiplication {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = getUserInput("Enter First Number: ");
        int number2 = getUserInput("Enter Second Number: ");
        int base = getUserInput("Enter Base(Which Base are above numbers): ");
        int result = 0;
        int iteration = 0;
        while (number2 > 0) {
            int lastDigit = number2 % 10;
            int temporaryNumber1 = number1;
            int oneDigitSum = 0;
            int carryOver = 0;
            int itr = 0;

            while (temporaryNumber1 > 0) {

                int remainder = temporaryNumber1 % 10;
                oneDigitSum = (int) Math.pow(10, itr++) * (((remainder * lastDigit) + carryOver) % base) + oneDigitSum;
                carryOver = ((remainder * lastDigit) + carryOver) / base;
                temporaryNumber1 /= 10;
            }
            oneDigitSum = (int) Math.pow(10, itr++) * carryOver + oneDigitSum;
            System.out.println((int) Math.pow(10, iteration) * oneDigitSum);
            result = anyBaseAddition(result, (int) Math.pow(10, iteration++) * oneDigitSum, base);
            number2 /= 10;
        }
        System.out.println(result);
    }

    public static int anyBaseAddition(int number1, int number2, int base) {
        int result = 0;
        int carryOver = 0;
        int iteration = 0;

        while (number1 > 0 || number2 > 0) {
            int remainder1 = number1 % 10;
            int remainder2 = number2 % 10;

            remainder1 = carryOver != 0 ? remainder1 + 1 : remainder1;

            carryOver = (remainder1 + remainder2) >= base ? 1 : 0;
            int lastDigit = carryOver != 0 ? (remainder1 + remainder2) - base : remainder1 + remainder2;

            result = (int) Math.pow(10, iteration++) * lastDigit + result;

            number1 /= 10;
            number2 /= 10;
        }
        result = carryOver != 0 ? (int) Math.pow(10, iteration++) + result : result;
        return result;
    }

    public static int getUserInput(String printQuery) {
        System.out.print(printQuery);
        return scan.nextInt();
    }
}
