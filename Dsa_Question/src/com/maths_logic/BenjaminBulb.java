package com.maths_logic;

import java.util.Scanner;

/*
  You are given a certain amount of bulb and you need to find out after toggling how many bulb will be lightning.
      Suppose 20 bulbs are there
        here you will have 20 toggles for 20 bulbs
          1  2  3  4  5   . . . . 19 20
       1- all bulbs divisible by 1 will start lighting
       2- all bulbs divisible by 2 will toggle(if light is on it will get off)
       3- all bulbs divisible by 2 will toggle(if light is on it will get off)
       .
       .
       .
       19
       20
 */
public class BenjaminBulb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of bulb-: ");
        int number = scan.nextInt();
        int sqrt = 0;
        for (int i = 1; i <= number; i++) {
            sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                System.out.print(i + ", ");
            }
        }
        scan.close();
    }
}
