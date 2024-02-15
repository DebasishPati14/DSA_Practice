package com.linked_list_questions;

public class AddNode {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
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

        int size() {
            return this.size;
        }

        void addFirst(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (this.size == 0) {
                this.head = this.tail = node;
            } else {
                node.next = head;
                head = node;
            }
            this.size++;
        }

        void addAt(int data, int index) {
            if (index < 0 || index > this.size()) {
                System.out.println("Invalid index provided.");
                return;
            } else if (index == 0) {
                addFirst(data);
            } else if (index == this.size() - 1) {
                addLast(data);
            }

            Node node = new Node();
            node.data = data;
            node.next = null;

            Node tempNode = this.head;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    node.next = tempNode.next;
                    tempNode.next = node;
                    this.size++;
                    break;
                }
                tempNode = tempNode.next;
            }
        }

        void display() {
            Node temporaryNode = this.head;

            while (temporaryNode != null) {
                System.out.print(temporaryNode.data + " ");
                temporaryNode = temporaryNode.next;
            }

            System.out.println("\nSize: " + this.size() + "\n\n");
        }
    }

    public static void main(String[] args) {
        int[] arrayList = { 12, 57, 89, 90, 11 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }

        ll.display();
        ll.addAt(1400, 5);
        ll.display();

    }
}
