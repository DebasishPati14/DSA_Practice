package com.mathsLogic;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        int number = getUserInput("Enter Number First: ");
        int givenBase = getUserInput("Enter Number Base(Which Base is above number): ");
        int convertingBase = getUserInput("Enter Number Base(To which Base is the number will convert): ");

        long convertedBaseNumber = 0;
        int iteration = 0;

        while (number > 0) {
            int remainder = number % convertingBase;
            convertedBaseNumber = (int) Math.pow(givenBase, iteration++) * remainder + convertedBaseNumber;
            number /= convertingBase;
        }

        System.out.printf("Converted base number is: %d", convertedBaseNumber);
    }

    public static int getUserInput(String printQuery) {
        Scanner scan = new Scanner(System.in);
        System.out.print(printQuery);
        return scan.nextInt();
    }
}
