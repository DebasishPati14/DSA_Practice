package com.searching_sorting;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (!isSmaller(arr, j, minimumIndex)) {
                    minimumIndex = j;
                }
            }
            for (int num : arr) {
                System.err.print(num + " ");
            }
            if (i != minimumIndex) {
                swap(arr, i, minimumIndex);
            }
            System.out.println();
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing of index " + arr[i] + " and " + arr[j]);
        return arr[i] > arr[j];
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, -9, 7, 9, 6, 11 };

        selectionSort(arr);
        for (int i : arr) {
            System.err.print(i + " ");
        }
    }

}
