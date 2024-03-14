package com.linked_list_questions;

public class RemoveNode {
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

        void removeFirst() {
            if (this.size == 0) {
                System.out.println("List is empty.");
                return;
            } else if (this.size() == 1) {
                System.out.println("RemovedElement:" + head.data);
                head = tail = null;
            } else {
                System.out.println("RemovedElement:" + head.data);
                head = head.next;
            }
            this.size--;
        }

        void removeLast() {
            if (this.size == 0) {
                System.out.println("List is empty.");
                return;
            } else if (this.size() == 1) {
                head = tail = null;
            } else {
                Node tempNode = this.head;
                for (int i = 0; i < this.size(); i++) {
                    if (i == this.size - 2) {
                        tempNode.next = null;
                        this.tail = tempNode;
                        System.out.println("RemovedElement:" + tempNode.data);
                        break;
                    }
                    tempNode = tempNode.next;
                }
            }
            this.size--;
        }

        void removeAt(int index) {
            if (index < 0 || index > this.size()) {
                System.out.println("Invalid index provided.");
                return;
            } else if (index == 0) {
                removeFirst();
            } else if (index == this.size() - 1) {
                removeLast();
            }

            Node tempNode = this.head;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    Node nextNode = tempNode.next;
                    tempNode.next = nextNode.next;
                    System.out.println("RemovedElement:" + nextNode.data);
                    break;
                }
                tempNode = tempNode.next;
            }
            this.size--;
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
        int[] arrayList = { 12, 57, 89, 90, 11, 94, 01 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }

        ll.display();

        ll.removeAt(5);
        ll.display();
        // ll.removeLast();
        // ll.display();

    }
}
