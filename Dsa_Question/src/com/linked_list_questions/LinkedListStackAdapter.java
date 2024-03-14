package com.linked_list_questions;

public class LinkedListStackAdapter {

    public static void main(String[] args) {
        int[] arrayList = { 12, 57, 89, 90, 11, 94, 01 };
        LinkedList linkedlistG = new LinkedList();
        for (int item : arrayList) {
        	linkedlistG.push(item);
        }
        linkedlistG.display();
        linkedlistG.pop();
        linkedlistG.pop();
        linkedlistG.display();
    }
}

class Node{
    int data;
    Node next;
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private void addFirst(int data) {
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

    void push(int data) {
        this.addFirst(data);
    }

    void pop() {
        this.removeFirst();
    }

    int peek() {
        return this.head.data;
    }

    private void removeFirst() {
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