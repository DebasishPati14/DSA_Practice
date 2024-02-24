package com.recursion;

import java.util.ArrayList;

public class MazePathJump {
    public static void main(String[] args) {
        ArrayList<String> allPossiblePaths = getJumpedPaths(1, 1, 3, 3);
        System.out.println(allPossiblePaths);
    }

    private static ArrayList<String> getJumpedPaths(int sourceRow, int sourceCol, int destRow, int destCol) {
        if (sourceCol == destCol && sourceRow == destRow) {
            ArrayList<String> pathList = new ArrayList<>();
            pathList.add("");
            return pathList;

        }

        // ArrayList<String> horizontalMoves = new ArrayList<>();
        // ArrayList<String> verticalMoves = new ArrayList<>();
        ArrayList<String> resultantPath = new ArrayList<>();

        for (int hJump = 1; hJump <= destRow - sourceRow; hJump++) {
            ArrayList<String> horizontalMoves = getJumpedPaths(sourceRow + hJump, sourceCol, destRow, destCol);
            for (String path : horizontalMoves) {
                resultantPath.add("h" + hJump + path);
            }
        }

        for (int vJump = 1; vJump <= destCol - sourceCol; vJump++) {
            ArrayList<String> verticalMoves = getJumpedPaths(sourceRow, sourceCol + vJump, destRow, destCol);
            for (String path : verticalMoves) {
                resultantPath.add("v" + vJump + path);
            }
        }

        for (int dJump = 1; dJump <= destRow - sourceRow && dJump <= destCol - sourceCol; dJump++) {
            ArrayList<String> diagonalMove = getJumpedPaths(sourceRow + dJump, sourceCol + dJump, destRow, destCol);
            for (String path : diagonalMove) {
                resultantPath.add("d" + dJump + path);
            }

        }

        return resultantPath;
    }
}
