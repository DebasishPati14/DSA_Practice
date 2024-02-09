package com.patterns;

import java.util.Scanner;

/*
 Forward Slash: 
*
        *
                *
                        *
                                *
                                        *
                                                *



Backward Slash:
                                                        *
                                                *
                                        *
                                *
                        *
                *
        *
*


#                                               #
        #                               #
                #               #
                        #
                #               #
        #                               #
#                                               #
 */
public class SlashPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length");
        int length = scan.nextInt();

        forwardSlash(length);
        System.out.println("\n\n");
        backwardSlash(length);
        System.out.println("\n\n");
        crossSlash(length);
        scan.close();
    }

    static void backwardSlash(int length) {
        System.out.println("Backward Slash: ");
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j <= length; j++) {
                if (i != j) {
                    System.out.print("\t");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void forwardSlash(int length) {
        System.out.println("Forward Slash: ");

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    System.out.print("\t");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void crossSlash(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (i == j || length + 1 == i + j) {
                    System.out.print("#\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
