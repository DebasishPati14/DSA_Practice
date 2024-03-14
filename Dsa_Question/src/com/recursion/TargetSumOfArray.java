package com.recursion;

public class TargetSumOfArray {
    public static void main(String[] args) {
        int[] arrayELements = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        printElementIndices(arrayELements, 0, 90, "", 0);
    }

    private static void printElementIndices(int[] arrayELements, int idx, int targetSum, String answerStr, int mySum) {
        if (idx == arrayELements.length || mySum > targetSum) {
            return;
        }
        if (mySum == targetSum) {
            System.out.println(answerStr);
            return;
        }

        // for (int i = idx; i < arrayELements.length; i++) {
        printElementIndices(arrayELements, idx + 1, targetSum, answerStr + idx, mySum + arrayELements[idx]);
        printElementIndices(arrayELements, idx + 1, targetSum, answerStr, mySum);
        // }
    }
}
