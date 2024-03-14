package com.recursion;

public class PrintMazePath {
    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int destRow = 3;
        int destCol = 3;
        String fallbackString = "";
        printMazePathWays(sourceRow, sourceCol, destRow, destCol, fallbackString);
    }

    static void printMazePathWays(int sourceRow, int sourceCol, int destRow, int destCol,
            String fallbackString) {
        if (sourceRow == destRow && sourceCol == destCol) {
            System.out.println(fallbackString);
            return;
        }
        if (sourceRow < destRow) {
            printMazePathWays(sourceRow + 1, sourceCol, destRow, destCol, fallbackString + "h");
        }
        if (sourceCol < destCol) {
            printMazePathWays(sourceRow, sourceCol + 1, destRow, destCol, fallbackString + "v");
        }
    }
}
