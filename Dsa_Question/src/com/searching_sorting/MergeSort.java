package com.searching_sorting;

public class MergeSort implements SortNum {
    static int[] mergeSort(int[] arr, int first, int last) {
        if (first == last) {
            System.out.println("first: " + first);
            int[] conditionalArr = new int[1];
            conditionalArr[0] = arr[first];

            return conditionalArr;
        }
        int middle = (first + last) / 2;
        int[] firstSortedArray = mergeSort(arr, first, middle);
        int[] lastSortedArray = mergeSort(arr, middle + 1, last);
        int[] finalSortedArray = mergeTwoArray(firstSortedArray, lastSortedArray);
        for (int num : finalSortedArray) {
            System.err.print(num + " ");
        }
        System.out.println();
        return finalSortedArray;
    }

    static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        int[] resultArray = new int[arr1.length + arr2.length];
        int fillingIndex = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            System.out.println(fillingIndex + "Comparing of index " + arr1[index1] + " and " + arr2[index2]);
            if (arr1[index1] > arr2[index2]) {
                resultArray[fillingIndex] = arr2[index2];
                index2++;
            } else {
                resultArray[fillingIndex] = arr1[index1];
                index1++;
            }
            fillingIndex++;
        }

        if (index1 == arr1.length) {
            while (index2 != arr2.length) {
                resultArray[fillingIndex] = arr2[index2];
                fillingIndex++;
                index2++;
            }
        } else {
            while (index1 != arr1.length) {
                resultArray[fillingIndex] = arr1[index1];
                fillingIndex++;
                index1++;
            }
        }
        return resultArray;
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing of index " + arr[i] + " and " + arr[j]);
        return arr[i] < arr[j];
    }

    static int[] mergeSort1(int smallArr[], int firstIdx, int lastIdx) {

        if (firstIdx == lastIdx) {
            int[] constArray = new int[1];
            constArray[0] = smallArr[firstIdx];

            return constArray;
        }
        int middle = (firstIdx + lastIdx) / 2;
        int[] firstSortedArray = mergeSort1(smallArr, firstIdx, middle);
        int[] secondSortedArray = mergeSort1(smallArr, middle + 1, lastIdx);

        return mergeTwoArray(firstSortedArray, secondSortedArray);
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, -9, 7, 90 };
        int[] sortedFirstArr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int[] sortedSecondArr = { 4, 6, 8, 10, 14, 18, 20, 22, 26 };

        // int[] mergedArray = mergeTwoArray(sortedFirstArr, sortedSecondArr);

        int[] mergedArray = mergeSort1(arr, 0, arr.length - 1);
        for (int num : mergedArray) {
            System.err.print(num + " ");
        }
    }

}
