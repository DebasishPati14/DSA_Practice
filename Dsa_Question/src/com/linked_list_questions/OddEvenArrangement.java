package com.linked_list_questions;

import com.linked_list_questions.AddLastNode.Node;

public class OddEvenArrangement {
    static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        void addFirst(int data) {
            if (size == 0) {
                addLast(data);
                return;
            }
            Node node = new Node();
            node.data = data;
            node.next = this.head;

            this.head = node;
            size++;
        }

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

        void addAt(int data, int pos) {
            if (pos < 0 || pos > size) {
                System.out.println("Invalid pos provided.");
                return;
            } else if (pos == 0) {
                addFirst(data);
                return;
            } else if (pos == size) {
                addLast(data);
                return;
            }
            int tempPos = 0;
            Node tempNode = this.head;

            Node newNode = new Node();
            newNode.data = data;
            while (tempPos != pos - 1) {
                tempNode = tempNode.next;
                tempPos++;
            }

            Node farziNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = farziNode;
            size++;
        }

        LinkedList arrangeList() {
            Node tempNode = this.head;
            LinkedList resultList = new LinkedList();
            int evenListIdx = 0;

            while (tempNode != null) {
                if (tempNode.data % 2 == 0) {
                    resultList.addAt(tempNode.data, evenListIdx);
                    evenListIdx++;
                } else {
                    resultList.addLast(tempNode.data);
                }
                tempNode = tempNode.next;
            }
            return resultList;
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
    }

    public static void main(String[] args) {
        int[] arrayList = { 12, 57, 89, 90, 11, 94, 01 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.display();

        // ll.addAt(18, 30);
        LinkedList arrangedLL = ll.arrangeList();
        arrangedLL.display();

    }

}
