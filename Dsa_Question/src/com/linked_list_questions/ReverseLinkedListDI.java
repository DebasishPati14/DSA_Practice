package com.linked_list_questions;

/*
 1. You are given a partially written LinkedList class.
 
2. Here is a list of existing functions: 
2.1 addLast adds a new element with given value to the end of Linked List 
2.2. display-Prints the elements of linked list from front to end in a single line. All elements are separated by space 
2.3. size-Returns the number of elements in the linked list 
2.4. removeFirst Removes the first element from Linked List 
2.5. getFirst Returns the data of first element. 
2.6 getLast()-Returns the data of last element 
2.7. getAt Returns the data of element available at the index pasted 
2.8. addFirst-adds a new element with given value in front of linked list 
2.9. addAt adds a new element at a given index. 
2.10. removeLast-removes the last element of linked list
2.11. removeAt remove an element at a given index

3. You are required to complete the body of reversed function The function should be an iterative function and should reverse the contents of inked list by changing the "data" property of nodes
 
4. Input and Output is managed for you.
 */
public class ReverseLinkedListDI {
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

        void reverseListDI() {
            if (this.size == 0) {
                System.out.println("Sorry Linked List does not have anything");
            } else if (this.size == 1) {
                System.out.println("Sorry LinkedList has one element");
            }
            Node forwardNode = this.head;
            Node backwardNode = this.head;

            for (int i = 0, j = this.size() - 1; i < this.size(); i++, j--) {
                if (i >= j) {
                    break;
                }
                int temp = i;
                while (temp < j) {
                    backwardNode = backwardNode.next;
                    temp++;
                }
                temp = backwardNode.data;
                backwardNode.data = forwardNode.data;
                forwardNode.data = temp;

                forwardNode = forwardNode.next;
                backwardNode = forwardNode;
            }
        }

        void reverseLinkedListN2() {
            if (this.size == 0) {
                System.out.println("Sorry Linked List does not have anything");
            } else if (this.size == 1) {
                System.out.println("Sorry LinkedList has one element");
            }

            else {
                Node rightNode = this.head;
                Node leftNode = this.head;
                for (int i = 0, j = this.size() - 1; i < this.size; i++, j--) {
                    if (j <= i) {
                        break;
                    }
                    int temp = i;
                    while (temp < j) {
                        rightNode = rightNode.next;
                        temp++;
                    }

                    temp = leftNode.data;
                    leftNode.data = rightNode.data;
                    rightNode.data = temp;

                    rightNode = leftNode.next;
                    leftNode = leftNode.next;
                }
            }
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
                System.out.println(tempNode.data + " <-current= " + backWardNum + " =backward-> " + nod.data);
                int tempValue = tempNode.data;
                tempNode.data = nod.data;
                nod.data = tempValue;
                backWardNum--;
                tempNode = tempNode.next;

            }
        }
    }

    public static void main(String[] args) {
        int[] arrayList = { 0, 100, 200, 300, 400, 500, 600 };
        LinkedList ll = new LinkedList();
        for (int item : arrayList) {
            ll.addLast(item);
        }
        ll.display();
        ll.reverseListDI();
        ll.display();
        ll.reverseLinkedListN2();
        ll.display();
        ll.reverseLinkedListDataIterative();
        ll.display();

    }
}
