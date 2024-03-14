package com.stack_questions;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingTime {
    public static void main(String[] args) {
        // int[][] arr = new int[6][2];
        int[][] arr = { { 22, 28 }, { 1, 8 }, { 25, 27 }, { 14, 19 }, { 27, 30 }, { 5, 12 } };
        printMergeTimeLap(arr);
    }

    private static void printMergeTimeLap(int[][] arr) {
        Pair[] allTimePairs = new Pair[arr.length];

        for (int i = 0; i < arr.length; i++) {
            allTimePairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(allTimePairs);

        Stack<Pair> timeLapsStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                timeLapsStack.push(allTimePairs[i]);
                continue;
            }

            if (timeLapsStack.peek().endTime > allTimePairs[i].startTime) {
                int maxEndTime = (int) Math.max(timeLapsStack.peek().endTime, allTimePairs[i].endTime);
                Pair newPair = new Pair(timeLapsStack.peek().startTime, maxEndTime);
                timeLapsStack.pop();
                timeLapsStack.push(newPair);
            } else {
                timeLapsStack.push(allTimePairs[i]);
            }
        }

        while (timeLapsStack.size() > 0) {
            Pair pr = timeLapsStack.pop();
            System.out.println(pr.startTime + " - " + pr.endTime);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        Pair(int sT, int eT) {
            this.startTime = sT;
            this.endTime = eT;
        }

        // this > other => (+)ve
        // this = other => 0
        // this < other => (-)ve
        @Override
        public int compareTo(Pair otherPair) {
            if (this.startTime > otherPair.startTime) {
                return +1;
            } else if (this.startTime < otherPair.startTime) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
