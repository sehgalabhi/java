package com.java.logics;

public class SinglyLinkedList<T extends Number> {

	private Node<T> head;

	private int size;

	public void add(T element) {

		Node<T> newNode = new Node<>();
		newNode.value = element;
		Node<T> current = head;
		while (true) {

			if (head == null) {
				head = newNode;
				break;
			} else if (current.nextRef == null) {
				current.nextRef = newNode;
				break;
			} else {
				current = current.nextRef;

			}
		}
	}

	public void traverse() {
		Node<T> current = head;
		while (current != null) {
			current.print();
			current = current.nextRef;
		}
	}

	public void reverse() {
		Node<T> current = head;
		Node<T> next = null;
		Node<T> prev = null;
		while (current != null) {
			next = current.nextRef;
			current.nextRef = prev;
			prev = current;

			current = next;

		}

		head = prev;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i + 1);
		}

		list.traverse();

		list.reverse();

		list.traverse();
	}

}
