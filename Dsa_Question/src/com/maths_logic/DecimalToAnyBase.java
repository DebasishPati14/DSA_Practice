package com.maths_logic;

import java.util.Scanner;

/*
 * 89912 - 8 => 257470
 * 32 - 2 => 100000
 * 164 - 16 => 104
 * 
 */

public class DecimalToAnyBase {
    public static void main(String[] args) {
        int number = getUserInput("Enter Number First: ");
        int base = getUserInput("Enter Digit to Count: ");

        long convertedBaseNumber = 0;
        int iteration = 0;

        while (number > 0) {
            int remainder = number % base;
            convertedBaseNumber = (int) Math.pow(10, iteration++) * remainder + convertedBaseNumber;
            number /= base;
        }

        System.out.printf("Converted base number is: %d", convertedBaseNumber);
    }

    public static int getUserInput(String printQuery) {
        Scanner scan = new Scanner(System.in);
        System.out.println(printQuery);
        return scan.nextInt();
    }
}
