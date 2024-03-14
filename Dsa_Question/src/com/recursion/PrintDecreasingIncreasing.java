package com.recursion;

import java.util.Scanner;

public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintDecreasing pD = new PrintDecreasing();
        int num = scan.nextInt();

        printDecreasingNum(num);
        System.out.println();
        scan.close();
    }

    static void printDecreasingNum(int num) {
        if (num == 0) {
            System.out.print("\n <----------------------------------------------------> \n");
            return;
        }
        System.out.print(num + " <-> ");
        printDecreasingNum(num - 1);
        System.out.print(num + " <-> ");
    }
}
