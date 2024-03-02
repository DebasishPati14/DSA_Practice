package com.searching_sorting;

public class QuickSort implements SortNum {
    public static void main(String[] args) {
        int[] arrOfNumbers = { 2, 8, 4, 3, 9, 1, 7, 6, 5 };

        quickSort(arrOfNumbers, 0, arrOfNumbers.length - 1);
        for (int num : arrOfNumbers) {
            System.out.print(num + ", ");

        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        System.out.println("Swapping :" + i + ", " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing of index " + arr[i] + " and " + arr[j]);
        return arr[i] < arr[j];
    }

    private static void quickSort(int[] arrOfNumbers, int first, int last) {
        if (first > last) {
            return;
        }

        int pivot = arrOfNumbers[last];
        int pivotIdx = partitionOfArray(arrOfNumbers, pivot, first, last);
        quickSort(arrOfNumbers, first, pivotIdx - 1);
        quickSort(arrOfNumbers, pivotIdx + 1, last);

    }

    private static int partitionOfArray(int[] arrOfNumbers, int pivot, int first, int last) {
        SortNum sN = new QuickSort();
        System.out.println("Pivot: " + pivot);
        int i = first;
        int j = first;
        while (i <= last) {
            if (arrOfNumbers[i] > pivot) {
                i++;
            } else {
                sN.swap(arrOfNumbers, i, j);
                i++;
                j++;
            }
        }
        return (j - 1);
    }
}
