package com.searching_sorting;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // int minimumIndex = i;
            // for (int j = i + 1; j < arr.length; j++) {
            // if (!isSmaller(arr, j, minimumIndex)) {
            // minimumIndex = j;
            // }
            // }
            // for (int num : arr) {
            // System.err.print(num + " ");
            // }
            // if (i != minimumIndex) {
            // swap(arr, i, minimumIndex);
            // }
            for (int j = i + 1; j > 0; j--) {
                if (isBigger(arr, j - 1, j)) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }

            for (int num : arr) {
                System.err.print(num + "-> ");
            }
            System.out.println();
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isBigger(int[] arr, int i, int j) {
        System.out.println("Comparing of index " + arr[i] + " and " + arr[j]);
        return arr[i] > arr[j];
    }

    public static void main(String[] args) {
        // int[] arr = { 100, 4, -9, 7, 90 };
        int[] arr = { 89, 90, 91, 92, 93 };

        insertionSort(arr);
        for (int i : arr) {
            System.err.print(i + " ");
        }
    }
}
