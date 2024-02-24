package com.recursion;

public class FindingIndices {
    public static void main(String[] args) {

        int[] fakeArr = { 21, 42, 15, 13, 4, 15, 15, 15 };

        int[] foundIndices = findLastIndex(fakeArr, 15, fakeArr.length - 1, 0);
        for (int i : foundIndices) {
            System.out.println("Present Index At: " + i);
        }
    }

    static int[] findLastIndex(int[] arr, int element, int index, int fsf) {
        if (index == 0) {
            int[] res = new int[fsf];
            return res;
        }
        if (element == arr[index]) {
            fsf++;
        }
        System.out.println(index);
        int[] foundIndex = findLastIndex(arr, element, index - 1, fsf);
        if (element == arr[index]) {
            foundIndex[--fsf] = index;
        }
        return foundIndex;

    }
}
