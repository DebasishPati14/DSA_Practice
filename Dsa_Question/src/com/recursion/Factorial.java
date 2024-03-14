package com.recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int fac = printFactorialNum(num);
        System.out.println("Factorail: " + fac);
        scan.close();
    }

    static int printFactorialNum(int num) {
        if (num == 1) {
            System.out.print("\n <----------------------------------------------------> \n");
            return 1;
        }
        return num * printFactorialNum(num - 1);
    }
}
