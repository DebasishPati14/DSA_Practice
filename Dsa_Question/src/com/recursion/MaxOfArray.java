package com.recursion;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int num = scan.nextInt();
        // int[] arrayNumbers = new int[num];

        // for (int i = 0; i < num; i++) {
        // arrayNumbers[i] = scan.nextInt();
        // }

        int[] fakeArr = { 21, 42, 13, 4, 15 };
        // printArray(fakeArr, 0);
        int max = findMaximum(fakeArr, 0);
        System.out.println("Maximum: " + max);
        scan.close();
    }

    static int findMaximum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int maximum = arr[index + 1] > arr[index] ? arr[index + 1] : arr[index];
        findMaximum(arr, index + 1);
        System.out.println("Maximum: " + maximum + "Idx: " + index);
        return maximum;
    }
}
