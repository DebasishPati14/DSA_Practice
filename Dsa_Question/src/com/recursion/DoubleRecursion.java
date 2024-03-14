package com.recursion;

import java.util.Scanner;

public class DoubleRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        printDoubleNum(num);
        System.out.println("Done: ");
        scan.close();
    }

    static void printDoubleNum(int num) {
        if (num == 0) {
            return;
        }
        System.out.print("-> " + num);

        printDoubleNum(num - 1);
        System.out.print("<- " + num);
        printDoubleNum(num - 1);
        System.out.print("Post: " + num);
        System.out.println("\n\n");

    }
}
