package com.linked_list_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddLastNode {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int value) {
            Node node = new Node();
            node.data = value;
            node.next = null;
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        int size() {
            return size;
        }

        void display() {
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }
            System.out.println("\n\nSize: " + size());
        }
    }

    public static void testList(LinkedList linkedList) {
        for (Node node = linkedList.head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println("\nSize" + linkedList.size);

        if (linkedList.size > 0) {
            System.out.println(linkedList.tail.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList ll = new LinkedList();
        System.out.println("Enter addLast with number: ");
        String str = bufferedReader.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                ll.addLast(val);
            }
            str = bufferedReader.readLine();
        }

        ll.display();

        // testList(ll);
    }

}
