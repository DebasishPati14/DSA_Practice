package com.recursion;

import java.util.ArrayList;

public class StairCaseLanding {
    public static void main(String[] args) {
        int num = 4;
        ArrayList<Integer> possiblePaths = getPossiblePathsToComeDownstairs(num);

        System.out.println(possiblePaths);
    }

    private static ArrayList<Integer> getPossiblePathsToComeDownstairs(int num) {

        if (num == 0) {
            ArrayList<Integer> pathList = new ArrayList<>();
            pathList.add(0);
            return pathList;
        }
        if (num < 0) {
            ArrayList<Integer> pathList = new ArrayList<>();
            return pathList;
        }

        ArrayList<Integer> possiblePaths1 = getPossiblePathsToComeDownstairs(num - 1);
        ArrayList<Integer> possiblePaths2 = getPossiblePathsToComeDownstairs(num - 2);
        ArrayList<Integer> possiblePaths3 = getPossiblePathsToComeDownstairs(num - 3);
        ArrayList<Integer> updatedPossiblePath = new ArrayList<>();

        for (int eachPath : possiblePaths1) {
            updatedPossiblePath.add(eachPath * 10 + 1);
        }

        for (int eachPath : possiblePaths2) {
            updatedPossiblePath.add(eachPath * 10 + 2);
        }

        for (int eachPath : possiblePaths3) {
            updatedPossiblePath.add(eachPath * 10 + 3);
        }

        return updatedPossiblePath;
    }
}
