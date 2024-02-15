package com.linked_list_questions;

/*
QUESTION
Get Value In Linked List
 
1. You are given a partially written LinkedList class
 
2. Here is a list of existing functions
2.1 addLast()- adds a new element with given value to the end of Linked List
2.2. display()-Prints the elements of linked list from front to end in single line. All elements are separated by space
2.3. size()-Returns the number of elements in the linked st
2.4 removeFirst()- Removes the first element from Linked List.
 
3. You are required to complete the body of get int.(data Value) and gate function 
3.1 getFirst()->Should return the data of first element. If empty should return -1 and print "List is empty"
3.2 getLast()-> Should return the data of last element. If empty should return -1 and print "List is empty"
3.3 getAt() ->  Should return the data of element available at the index passed. If empty should return -1 and print "List is empty". If invalid index(more than size) is passed then print "Invalid arguments"
 */

public class GetValue {
    public static class Node {
        int data;
        Node next;
    }

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
    }

    public static void main(String[] args) {
        int[] arrayNumbers = { 23, 67, 91, 01, 11 };
        LinkedList linkedList = new LinkedList();
        for (int i : arrayNumbers) {
            linkedList.addLast(i);
        }

        linkedList.display();
        int firstNodeData = linkedList.getFirst();
        System.out.println("firstNodeData: " + firstNodeData);
        int lastNodeData = linkedList.getLast();
        System.out.println("lastNodeData: " + lastNodeData);
        int getAtNodeData = linkedList.getAt(2);
        System.out.println("getAtNodeData: " + getAtNodeData);
    }

}
