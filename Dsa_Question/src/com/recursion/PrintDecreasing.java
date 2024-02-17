package com.recursion;

import java.util.Scanner;

public class PrintDecreasing {
    int tableNum = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintDecreasing pD = new PrintDecreasing();
        pD.tableNum = scan.nextInt();

        printDecreasingNum(pD.tableNum);
        System.out.println();
        pD.printTable(10);
        scan.close();
    }

    static void printDecreasingNum(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num + " <-> ");
        printDecreasingNum(--num);
    }

    void printTable(int num) {
        if (num == 0) {
            return;
        }
        printTable(num - 1);
        System.out.print(tableNum + " * " + num + " = " + tableNum * (num) + "\n");
    }
}
