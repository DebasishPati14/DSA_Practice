package com.linked_list_questions;

public class MergeSort {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        int getSize() {
            return this.size;
        }

        void addLast(int num) {
            Node newNode = new Node();
            newNode.data = num;
            newNode.next = null;

            if (this.size == 0) {
                this.head = this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
            size++;
        }

        void display() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data + ", ");
                node = node.next;
            }
        }

        static LinkedList mergeTwoSortedLinkedList(LinkedList list1, LinkedList list2) {
            Node firstListNode = list1.head;
            Node secondListNode = list2.head;
            LinkedList sortedList = new LinkedList();

            while (firstListNode != null && secondListNode != null) {
                if (firstListNode.data < secondListNode.data) {
                    sortedList.addLast(firstListNode.data);
                    firstListNode = firstListNode.next;
                } else {
                    sortedList.addLast(secondListNode.data);
                    secondListNode = secondListNode.next;
                }
            }

            if (firstListNode == null) {
                while (secondListNode != null) {
                    sortedList.addLast(secondListNode.data);
                    secondListNode = secondListNode.next;
                }
            } else {
                while (firstListNode != null) {
                    sortedList.addLast(firstListNode.data);
                    firstListNode = firstListNode.next;
                }
            }
            return sortedList;
        }

        public LinkedList mergeSortLinkedList(int startIdx, int endIdx) {
            if (startIdx == endIdx) {
                int num = 0;
                Node node = this.head;
                while (num != startIdx - 1) {
                    node = node.next;
                    num++;
                }

                LinkedList ll = new LinkedList();
                ll.addLast(node.data);
                return ll;
            }

            int middle = (startIdx + endIdx) / 2;
            LinkedList firstSortedList = mergeSortLinkedList(startIdx, middle);
            LinkedList secondSortedList = mergeSortLinkedList(middle + 1, endIdx);
            LinkedList mergedLL = mergeTwoSortedLinkedList(firstSortedList, secondSortedList);
            System.out.print("\nFirstSorted :");
            firstSortedList.display();
            System.out.print("\nSecondSorted :");
            secondSortedList.display();
            System.out.print("\nMergedSorted :");
            mergedLL.display();
            return mergedLL;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int[] arrayOfNumbers = { 2, 8, 4, 5, 1, 7, 6, 3 };

        for (int num : arrayOfNumbers) {
            ll.addLast(num);
        }
        System.out.print("Before Sorting: ");
        ll.display();
        ll.mergeSortLinkedList(1, ll.getSize());
        System.out.print("\nAfter Sorting: ");
        ll.display();
    }
}
