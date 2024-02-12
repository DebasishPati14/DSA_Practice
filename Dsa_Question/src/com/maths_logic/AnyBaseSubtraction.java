package com.maths_logic;

import java.util.Scanner;

public class AnyBaseSubtraction {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = getUserInput("Enter Bigger Number: ");
        int number2 = getUserInput("Enter Smaller Number: ");
        int base = getUserInput("Enter Base(Which Base are above numbers): ");
        long result = 0;
        int borrow = 0;
        int iteration = 0;

        while (number1 > 0) {
            int remainder1 = number1 % 10;
            int remainder2 = number2 % 10;

            remainder1 = borrow != 0 ? remainder1 - 1 : remainder1;
            borrow = (remainder1 - remainder2) < 0 ? 1 : 0;
            int lastDigit = (remainder1 - remainder2) < 0 ? (base + remainder1) - remainder2 : remainder1 - remainder2;

            result = (int) Math.pow(10, iteration++) * lastDigit + result;

            number1 /= 10;
            number2 /= 10;
        }
        // result = carryOver != 0 ? (int) Math.pow(10, iteration++) + result : result;
        System.out.println("Addition of numbers in given base:" + result);
        scan.close();
    }

    public static int getUserInput(String printQuery) {
        System.out.print(printQuery);
        return scan.nextInt();
    }
}
