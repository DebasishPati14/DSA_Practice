package com.recursion;

import java.util.Scanner;

public class PowerOfNum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number: \n");

        int num = scan.nextInt();
        System.out.print("Enter Power: \n");
        int pow = scan.nextInt();

        int facLin = printPowerOfNumLinear(num, pow);
        System.out.println("Factorial Liner: " + facLin);

        int facLog = printPowerOfNumLogarithmic(num, pow);
        System.out.println("Factorial Logarithmic: " + facLog);
        scan.close();
    }

    static int printPowerOfNumLinear(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        int square = num * printPowerOfNumLinear(num, pow - 1);
        System.out.println("Multiplying : " + square);
        return square;
    }

    // 2^5 = 2^2 . 2^2 . 2
    static int printPowerOfNumLogarithmic(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow % 2 == 0) {
            int resultNby2 = printPowerOfNumLinear(num, pow / 2);
            System.out.println("Multiplying : " + resultNby2);
            return resultNby2 * resultNby2;
        } else {
            int resultNby2 = printPowerOfNumLinear(num, pow / 2);
            System.out.println("Multiplying : " + resultNby2);
            return resultNby2 * resultNby2 * num;
        }
    }
}
