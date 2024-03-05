package com.array_questions;

public class RotateArray {
    public static void main(String[] args) {
        int[] arrayOfInt = { 2, 5, 3, 1, 4 };

        for (int i = 0, j = arrayOfInt.length - 1; i < arrayOfInt.length / 2; i++, j--) {
            int tempNum = arrayOfInt[j];
            System.out.println(tempNum);
            arrayOfInt[j] = arrayOfInt[i];
            arrayOfInt[i] = tempNum;
        }

        for (int num : arrayOfInt) {
            System.out.print(num + ", ");
        }
    }
}
