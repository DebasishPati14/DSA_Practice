package com.recursion;

import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args) {
        int sourcepoint = 1;
        int destCol = 3;
        int destRow = 3;
        ArrayList<String> mazePaths = getMazePaths(sourcepoint, sourcepoint, destRow, destCol);
        System.out.println(mazePaths);
    }

    static ArrayList<String> getMazePaths(int sourceRow, int sourceCol, int destRow, int destCol) {

        if (sourceRow == destRow && sourceCol == destCol) {
            ArrayList<String> pathList = new ArrayList<>();
            pathList.add("");
            return pathList;
        }

        ArrayList<String> horizontalMoves = new ArrayList<>();
        ArrayList<String> verticalMoves = new ArrayList<>();

        if (sourceCol < destCol) {
            horizontalMoves = getMazePaths(sourceRow, sourceCol + 1, destRow, destCol);
        }

        if (sourceRow < destRow) {
            verticalMoves = getMazePaths(sourceRow + 1, sourceCol, destRow, destCol);
        }

        ArrayList<String> resultantPath = new ArrayList<>();

        for (String path : horizontalMoves) {
            resultantPath.add("h" + sourceRow + path);
        }

        for (String path : verticalMoves) {
            resultantPath.add("v" + sourceCol + path);

        }

        return resultantPath;

    }

    static ArrayList<String> getMazePathsWithCoordinates(int sourceRow, int sourceCol, int destRow, int destCol) {
        if (sourceCol == destCol && sourceRow == destRow) {
            ArrayList<String> pathList = new ArrayList<>();
            pathList.add("");
            return pathList;

        }

        ArrayList<String> horizontalMoves = new ArrayList<>();
        ArrayList<String> verticalMoves = new ArrayList<>();
        ArrayList<String> resultantPath = new ArrayList<>();

        if (sourceCol < destCol) {
            horizontalMoves = getMazePathsWithCoordinates(sourceRow, sourceCol + 1, destRow, destCol);
        }

        if (sourceRow < destRow) {
            verticalMoves = getMazePathsWithCoordinates(sourceRow + 1, sourceCol, destRow, destCol);
        }

        for (String str : verticalMoves) {
            resultantPath.add("v" + "(" + sourceCol + ", " + (sourceRow + 1) + ")" + str);
        }
        for (String str : horizontalMoves) {
            resultantPath.add("h" + "(" + (sourceCol + 1) + ", " + sourceRow + ")" + str);
        }

        return resultantPath;
    }
}
