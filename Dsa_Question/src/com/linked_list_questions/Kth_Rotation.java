package com.linked_list_questions;

public class Kth_Rotation {
    static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int num) {
            Node node = new Node();
            node.data = num;
            node.next = null;

            if (this.size == 0) {
                this.head = this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        int size() {
            return this.size;
        }

        void removeFirst() {
            if (size == 0) {
                System.out.println("Sorry Linked List does not have anything");
            } else {
                this.head = head.next;
                this.size--;
            }
        }

        void display() {
            Node temporaryNode = this.head;

            while (temporaryNode != null) {
                System.out.print(temporaryNode.data + " ");
                temporaryNode = temporaryNode.next;
            }

            System.out.println("\nSize: " + this.size() + "\n");
        }

        int getFirst() {
            if (this.size() == 0)
                System.out.println("List is empty.");
            return this.head == null ? -1 : this.head.data;
        }

        int getLast() {
            if (this.size() == 0)
                System.out.println("List is empty.");
            return this.size == 0 ? -1 : this.tail.data;
        }

        void clearList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        Node getAtNode(int index) {
            int temp = 0;
            Node tempNode = this.head;
            while (index != temp) {
                tempNode = tempNode.next;
                temp++;
            }
            return tempNode;
        }

        void reverseLinkedListDataIterative() {
            Node tempNode = this.head;
            int backWardNum = this.size - 1;

            while (backWardNum > this.size / 2) {
                Node nod = getAtNode(backWardNum);
                int tempValue = tempNode.data;
                tempNode.data = nod.data;
                nod.data = tempValue;
                backWardNum--;
                tempNode = tempNode.next;

            }
        }

        void kReverseLinkedList(int k) {
            LinkedList firstKLists = new LinkedList();
            LinkedList kReverseList = new LinkedList();
            int i = 1;
            kReverseList.addLast(this.head.data);
            boolean lastRotationSkip = (this.size() % k) == 0;
            while (this.size() > 0) {
                int currentValue = getFirst();
                this.removeFirst();
                firstKLists.addLast(currentValue);
                if (i % k == 0) {
                    firstKLists.reverseLinkedListDataIterative();
                    kReverseList.tail.next = firstKLists.head;
                    kReverseList.tail = firstKLists.tail;
                    kReverseList.size += k;
                    firstKLists.clearList();
                }

                i++;
            }
            if (!lastRotationSkip) {
                kReverseList.tail.next = firstKLists.head;
                kReverseList.tail = firstKLists.tail;
                kReverseList.size += firstKLists.size();
            }
            kReverseList.removeFirst();
            this.head = kReverseList.head;
            this.tail = kReverseList.tail;
            this.size = kReverseList.size;

        }
    }

    public static void main(String[] args) {
        int[] arrayList = { 0, 100, 200, 300, 400, 500, 600, 700 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.display();
        // ll.reverseLinkedListDataIterative();
        // ll.display();
        ll.kReverseLinkedList(3);
        ll.display();
    }
}
