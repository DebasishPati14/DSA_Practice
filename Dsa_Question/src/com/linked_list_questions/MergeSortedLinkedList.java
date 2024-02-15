package com.linked_list_questions;

public class MergeSortedLinkedList {
    public static void main(String[] args) {

        GlobalLinkedList sortedList1 = new GlobalLinkedList();
        GlobalLinkedList sortedList2 = new GlobalLinkedList();

        int[] sortedFirstArr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int[] sortedSecondArr = { 4, 6, 8, 10, 14, 18, 20, 22, 26 };

        for (int num : sortedFirstArr) {
            sortedList1.addLast(num);
        }

        for (int num : sortedSecondArr) {
            sortedList2.addLast(num);
        }
        sortedList1.display();
        sortedList2.display();
        GlobalLinkedList mergeList = new GlobalLinkedList();
        mergeList.mergeTowSortedList(sortedList1, sortedList2);
        mergeList.display();

    }
}
