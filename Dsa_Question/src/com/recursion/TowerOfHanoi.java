package com.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of Wheels: ");
        int num = scan.nextInt();
        System.out.println("Enter each tower: ");

        // String tower1 = scan.nextLine();
        // String tower2 = scan.nextLine();
        // String tower3 = scan.nextLine();

        printWheelTransition(num, "_A_", "_B_", "_C_");
        scan.close();
    }

    // tower 3 is helper tower
    static void printWheelTransition(int num, String tower1, String tower2, String tower3) {
        if (num == 0) {
            return;
        }
        printWheelTransition(num - 1, tower1, tower3, tower2);// moving from tower1 to tower3 w.t.h. of tower2
        System.out.println("Moving : " + num + "kg wheel from <" + tower1 + "> to <" + tower2 + ">");
        printWheelTransition(num - 1, tower3, tower2, tower1);// moving from tower1 to tower3 w.t.h. of tower2
    }
}
