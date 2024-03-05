package com.linked_list_questions;

public class DuplicateFromSortedList {
    public static void main(String[] args) {
        GlobalLinkedList linkedList = new GlobalLinkedList();
        int[] sortedArray = { 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8, 8, 9 };
        for (int item : sortedArray) {
            linkedList.addLast(item);
        }
        System.out.print("Before remove: ");
        linkedList.display();
        linkedList.removeDuplicateFromSortedList();
        // System.out.println("\nAfter remove: ");
        // linkedList.display();
    }
}
