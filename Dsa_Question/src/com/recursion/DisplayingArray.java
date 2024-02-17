package com.recursion;

import java.util.Scanner;

public class DisplayingArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int num = scan.nextInt();
        // int[] arrayNumbers = new int[num];

        // for (int i = 0; i < num; i++) {
        // arrayNumbers[i] = scan.nextInt();
        // }

        int[] fakeArr = { 1, 2, 3, 4, 5 };
        // printArray(fakeArr, 0);
        // System.out.println("ForwardDone\n<----------> ");
        printReverseArray(fakeArr, 0);
        scan.close();
    }

    static void printArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        printArray(arr, index + 1);
    }

    static void printReverseArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        printReverseArray(arr, index + 1);
        System.out.println("Item: " + arr[index] + "Idx: " + index);
    }
}
