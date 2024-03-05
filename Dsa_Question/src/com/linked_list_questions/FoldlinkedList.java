package com.linked_list_questions;

public class FoldLinkedList {

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

        Node leftNode = head;

        void reverseListDataRecursive(Node currentNode, int middleFlag) {
            if (currentNode == null) {
                return;
            }
            reverseListDataRecursive(currentNode.next, middleFlag + 1);

            if (middleFlag > size() / 2) {
                System.out.println("Did it go " + leftNode.data + ", " + middleFlag + "" + currentNode.data);
                Node temp = leftNode.next;
                leftNode.next = currentNode;
                currentNode.next = temp;
                leftNode = temp;
            } else if (size() / 2 == middleFlag) {
                // if (size() % 2 == 0) {
                // currentNode.next = leftNode.next.next;
                // leftNode.next = currentNode;
                // this.tail = leftNode;
                // this.tail.next = null;
                // } else {
                // currentNode.next = null;
                // this.tail = currentNode;
                // return;
                // }
                currentNode.next = null;
                this.tail = currentNode;
                this.tail.next = null;
            } else {
                return;
            }

        }

        void displayFoldedLL() {
            if (this.size == 0) {
                System.out.println("Sorry Linked List does not have anything");
            } else if (this.size == 1) {
                System.out.println("Sorry LinkedList has one element");
            }

            leftNode = this.head;
            reverseListDataRecursive(this.head, 0);
            this.display();
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

    }

    public static void main(String[] args) {
        int[] arrayList = {  100, 200, 300, 400, 500, 600 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.display();
        ll.displayFoldedLL();
    }
}
