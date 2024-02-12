package com.mathsLogic;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        int number = getUserInput("Enter Number First: ");
        int base = getUserInput("Enter Number Base(Which Base is above number): ");

        long decimalBaseNumber = 0;
        int iteration = 0;

        while (number > 0) {
            decimalBaseNumber += (int) Math.pow(base, iteration++) * (number % 10);
            number /= 10;
        }

        System.out.printf("Converted base number is: %d", decimalBaseNumber);
    }

    public static int getUserInput(String printQuery) {
        Scanner scan = new Scanner(System.in);
        System.out.print(printQuery);
        return scan.nextInt();
    }
}
