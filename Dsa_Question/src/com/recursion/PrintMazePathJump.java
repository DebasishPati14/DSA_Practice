package com.recursion;

public class PrintMazePathJump {
    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int destRow = 3;
        int destCol = 3;
        String fallbackString = "";
        printMazeJumpPathWays(sourceRow, sourceCol, destRow, destCol, fallbackString);
    }

    static void printMazeJumpPathWays(int sourceRow, int sourceCol, int destRow, int destCol,
            String fallbackString) {
        if (sourceRow == destRow && sourceCol == destCol) {
            System.out.println(fallbackString);
            return;
        }

        for (int hJump = 1; hJump <= destRow - sourceRow; hJump++) {
            printMazeJumpPathWays(sourceRow + hJump, sourceCol, destRow, destCol, fallbackString + "h" + hJump);
        }
        for (int vJump = 1; vJump <= destCol - sourceCol; vJump++) {
            printMazeJumpPathWays(sourceRow, sourceCol + vJump, destRow, destCol, fallbackString + "v" + vJump);
        }
        for (int dJump = 1; dJump <= destRow - sourceRow && dJump <= destCol - sourceCol; dJump++) {
            printMazeJumpPathWays(sourceRow + dJump, sourceCol + dJump, destRow, destCol, fallbackString + "d" + dJump);
        }
    }
}
