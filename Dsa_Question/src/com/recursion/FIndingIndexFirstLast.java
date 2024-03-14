package com.recursion;

import java.util.Scanner;

public class FIndingIndexFirstLast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int num = scan.nextInt();
        // int[] arrayNumbers = new int[num];

        // for (int i = 0; i < num; i++) {
        // arrayNumbers[i] = scan.nextInt();
        // }

        int[] fakeArr = { 21, 42, 15, 13, 4, 15, 15, 15 };
        // printArray(fakeArr, 0);
        int max = findFirstIndex(fakeArr, 105, 0);
        System.out.println("FirstIndex: " + max);

        int min = findLastIndex(fakeArr, 15, fakeArr.length - 1);
        System.out.println("LastIndex: " + min);
        scan.close();
    }

    static int findLastIndex(int[] arr, int element, int index) {
        if (index == -1) {
            return -1;
        } else if (element == arr[index]) {
            return index;
        }
        System.out.println(index);
        int foundIndex = findLastIndex(arr, element, index - 1);
        return foundIndex;

    }

    static int findFirstIndex(int[] arr, int element, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (element == arr[index]) {
            return index;
        }
        System.out.println(index);
        int foundIndex = findFirstIndex(arr, element, index + 1);
        return foundIndex;
    }
}
