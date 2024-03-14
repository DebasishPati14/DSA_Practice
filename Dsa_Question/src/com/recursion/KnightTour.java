package com.recursion;

public class KnightTour {
    public static void main(String[] args) {
        int size = 5;
        int[][] chessBoard = new int[size][size];
        boolean[][] hasJumped = new boolean[size][size];
        int row = 4;
        int col = 4;
        int totalJumps = 0;
        String jumpedPaths = "";
        printPossibleKnightTour(chessBoard, row, col, "", jumpedPaths, totalJumps, hasJumped);
    }

    private static void printPossibleKnightTour(int[][] chessBoard, int row, int col, String points, String jumpedPaths,
            int totalJumps,
            boolean[][] hasJumped) {
        if (row < 0 || col < 0 || row >= chessBoard.length || col >= chessBoard.length || hasJumped[row][col] == true) {
            return;
        }

        if (totalJumps == 22) {
            System.out.println(jumpedPaths);
            System.out.println("\n" + points);
            return;
        }

        hasJumped[row][col] = true;
        printPossibleKnightTour(chessBoard, row - 2, col + 1, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "U2R1, ", totalJumps + 1,
                hasJumped);
        printPossibleKnightTour(chessBoard, row - 1, col + 2, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "U1R2, ", totalJumps + 1, hasJumped);
        printPossibleKnightTour(chessBoard, row + 1, col + 2, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "D1R2, ", totalJumps + 1, hasJumped);
        printPossibleKnightTour(chessBoard, row + 2, col + 1, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "D2R1, ", totalJumps + 1, hasJumped);

        printPossibleKnightTour(chessBoard, row + 2, col - 1, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "D2L1, ", totalJumps + 1, hasJumped);
        printPossibleKnightTour(chessBoard, row + 1, col - 2, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "D1L2, ", totalJumps + 1, hasJumped);
        printPossibleKnightTour(chessBoard, row - 1, col - 2, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "U1L2, ", totalJumps + 1, hasJumped);
        printPossibleKnightTour(chessBoard, row - 2, col - 1, points + "(" + row + "-" + col + "), ",
                jumpedPaths + "U2L1, ", totalJumps + 1, hasJumped);
    }
}
