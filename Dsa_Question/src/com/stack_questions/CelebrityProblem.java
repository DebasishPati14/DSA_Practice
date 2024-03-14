package com.stack_questions;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 1, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 1, 1, 1 } };
        findCelebrity(matrix);
    }

    private static void findCelebrity(int[][] matrix) {
        Stack<Integer> allElements = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            allElements.push(i);
        }

        while (allElements.size() > 2) {
            int row = allElements.pop();
            int col = allElements.pop();
            if (matrix[row][col] == 1) {
                allElements.push(col);
            } else {
                allElements.push(row);
            }
        }

        int candidateCol = allElements.pop();
        System.err.println(candidateCol);

        for (int i = 0; i < matrix.length; i++) {
            if (i != candidateCol && matrix[i][candidateCol] != 1 || matrix[candidateCol][i] != 0) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(candidateCol);
    }
}
