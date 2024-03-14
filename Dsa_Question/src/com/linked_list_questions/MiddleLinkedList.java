package com.linked_list_questions;

public class MiddleLinkedList {
	static class MiddleEleLinkedList {
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

		int getMiddleElement() {
			Node fastMovingNode, slowMovingNode = new Node();
			slowMovingNode = fastMovingNode = this.head;

			while (fastMovingNode.next != null && (fastMovingNode.next).next != null) {
				fastMovingNode = (fastMovingNode.next).next;
				slowMovingNode = slowMovingNode.next;
			}

			return slowMovingNode.data;
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

	public static void main(String[] args) {
		int[] arrayList = { 12, 57, 89, 90, 11, 94, 1908, 4 };
		MiddleEleLinkedList ll = new MiddleEleLinkedList();
		for (int item : arrayList) {
			ll.addLast(item);
		}
		ll.display();

		System.out.println(ll.getMiddleElement());
	}
}
