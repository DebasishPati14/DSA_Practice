package com.linked_list_questions;

import com.linked_list_questions.AddLastNode.Node;

class GlobalLinkedList {
    private Node head;
    private Node tail;
    private int size;

    void addLast(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    int getMiddleElement() {
        Node fastMovingNode, slowMovingNode = new Node();
        slowMovingNode = fastMovingNode = this.head;

        while (fastMovingNode.next != null && (fastMovingNode.next).next != null) {
            fastMovingNode = (fastMovingNode.next).next;
            slowMovingNode = slowMovingNode.next;
        }

        return slowMovingNode.data;
    }

    void removeFirst() {
        this.head = head.next;
        size--;
    }

    void display() {
        Node temporaryNode = this.head;
        while (temporaryNode != null) {
            System.out.print(temporaryNode.data + " ");
            temporaryNode = temporaryNode.next;
        }

        System.out.println("\nSize: " + this.size + "\n\n");
    }

    public void mergeTowSortedList(GlobalLinkedList sortedList1, GlobalLinkedList sortedList2) {
        Node firstListNode = sortedList1.head;
        Node secondListNode = sortedList2.head;
        while (firstListNode != null && secondListNode != null) {
            if (firstListNode.data < secondListNode.data) {
                this.addLast(firstListNode.data);
                firstListNode = firstListNode.next;
            } else if (secondListNode.data < firstListNode.data) {
                this.addLast(secondListNode.data);
                secondListNode = secondListNode.next;
            } else {
                this.addLast(secondListNode.data);
                this.addLast(firstListNode.data);
                secondListNode = secondListNode.next;
                firstListNode = firstListNode.next;
            }
        }

        if (firstListNode == null) {
            while (secondListNode != null) {
                this.addLast(secondListNode.data);
                secondListNode = secondListNode.next;
            }
        } else {
            while (firstListNode != null) {
                this.addLast(firstListNode.data);
                firstListNode = firstListNode.next;
            }
        }
    }

    public void removeDuplicateFromSortedList() {
        Node node = this.head;
        while (node != null) {
            int currentData = node.data;
            if (node.next != null && node.next.data == currentData) {
                node.next = node.next.next;
                this.size--;
            } else {
                node = node.next;
            }
        }
        this.display();
    }
}
