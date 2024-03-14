package com.recursion;

/*
0 0 0 0 0 
0 1 1 0 0 
0 1 1 0 0 
0 0 0 0 1 
1 1 1 0 0 

Expected Output
dddrrrdr
rrrddddr
rrrdrdlddr
rrrrdldddr
rrrrddlddr
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] mazePath = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 0 } };

        for (int i = 0; i < mazePath.length; i++) {
            for (int j = 0; j < mazePath[i].length; j++) {
                System.out.print(mazePath[i][j] + " ");
            }
            System.out.println();
        }
        boolean[][] pathChecked = new boolean[mazePath.length][mazePath[0].length];
        int row = 0;
        int col = 0;
        printFloodPath(mazePath, row, col, "", pathChecked);
    }

    private static void printFloodPath(int[][] mazePath, int row, int col, String possiblePath,
            boolean[][] pathChecked) {
        if (row < 0 || col < 0 || row == mazePath.length || col == mazePath[mazePath.length - 1].length
                || mazePath[row][col] == 1
                || pathChecked[row][col]) {
            return;
        }
        if (row == mazePath.length - 1 && col == mazePath[mazePath.length - 1].length - 1) {
            System.out.println(possiblePath);
            return;
        }

        pathChecked[row][col] = true;
        // Move up
        printFloodPath(mazePath, row - 1, col, possiblePath + "u", pathChecked);
        // Move left
        printFloodPath(mazePath, row, col - 1, possiblePath + "l", pathChecked);
        // Move down
        printFloodPath(mazePath, row + 1, col, possiblePath + "d", pathChecked);
        // Move right
        printFloodPath(mazePath, row, col + 1, possiblePath + "r", pathChecked);
        pathChecked[row][col] = false;

    }
}
