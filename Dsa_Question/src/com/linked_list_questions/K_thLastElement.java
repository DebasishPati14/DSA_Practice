package com.linked_list_questions;

class KthEleLinkedList {
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

    int getKthElement(int k) {

        if (size < k) {
            System.out.println("Invalid k index provided.");
            return 0;
        }
        Node fastMovingNode, kthNode = new Node();
        kthNode = fastMovingNode = this.head;

        for (int i = 0; i < k; i++) {
            fastMovingNode = fastMovingNode.next;
        }

        while (fastMovingNode.next != null) {
            fastMovingNode = fastMovingNode.next;
            kthNode = kthNode.next;
        }

        return kthNode.data;
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

public class K_thLastElement {
    public static void main(String[] args) {
        int[] arrayList = { 12, 57, 89, 90, 11, 94, 01 };
        KthEleLinkedList ll = new KthEleLinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.display();

        System.out.println(ll.getKthElement(4));
    }
}
