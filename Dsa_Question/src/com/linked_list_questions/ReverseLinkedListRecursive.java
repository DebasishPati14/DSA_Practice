package com.linked_list_questions;

public class ReverseLinkedListRecursive {
    public static class LinkedList {
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

        void addFirst(int num) {
            Node node = new Node();
            node.data = num;
            node.next = null;

            if (this.size == 0) {
                this.head = this.tail = node;
            } else {
                node.next = this.head;
                this.head = node;
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

        void removeLast() {
            if (size == 0) {
                System.out.println("Sorry Linked List does not have anything");
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

        void display() {
            Node temporaryNode = this.head;

            while (temporaryNode != null) {
                System.out.print(temporaryNode.data + " ");
                temporaryNode = temporaryNode.next;
            }

            System.out.println("\nSize: " + this.size() + "\n\n");
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

        int getAt(int index) {
            int dataAtIndex = -1;
            if (this.size() == 0)
                System.out.println("List is empty.");
            else if (this.size() < index - 1 || index < 0)
                System.out.println("Invalid arguments.");
            else {
                int j = 0;
                for (Node i = head; i != null; i = i.next) {
                    if (j == index) {
                        dataAtIndex = i.data;
                        break;
                    }
                    j++;
                }
            }
            return dataAtIndex;
        }

        private LinkedList reverseListRecursiveDI(Node node) {
            if (node.next == null) {
                LinkedList lt = new LinkedList();
                lt.addLast(node.data);
                return lt;
            }
            LinkedList tempList = reverseListRecursiveDI(node.next);
            tempList.addLast(node.data);
            return tempList;
        }

        private Node reverseListRecursivePI(Node currentNode) {
            if (currentNode.next == null) {
                // node.next = node;
                // this.head = node.next;
                return currentNode;
            }
            Node prevNode = reverseListRecursivePI(currentNode.next);
            prevNode.next = currentNode;
            if (currentNode == this.head) {
                this.head = this.tail;
                currentNode.next = null;
                this.tail = currentNode;
            }

            return currentNode;
        }

        private void displayReverseListRecursive() {
            LinkedList reversedList = this.reverseListRecursiveDI(this.head);
            System.out.println("Data Iterative Approach: ");
            reversedList.display();

        }

        void displayReverseListPI() {
            this.reverseListRecursivePI(this.head);

            System.out.println("Pointer Iterative Approach: ");
            this.display();
        }

    }

    public static void main(String[] args) {
        int[] arrayList = { 0, 100, 200, 300, 400, 500, 600 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.addFirst(-100);
        ll.display();
        ll.displayReverseListPI();
    }

}
