package com.ailhanli.priority_queue;

class Node<Integer> {
	Integer value;
	Node<Integer> next;
	Node<Integer> prev;

	public Node(Integer value) {
		super();
		this.value = value;
	}
}

public class PriorityQueue {

	private Node<Integer> head;
	private Node<Integer> tail;

	public void push(Integer newValue) {

		Node<Integer> node = new Node<>(newValue);
		if (head == null || tail == null) {
			head = node;
			tail = node;
		} else {
			Node<Integer> temp = head;
			boolean found = false;
			while (temp != null) {
				if (newValue < temp.value) {
					node.prev = temp.prev;
					node.next = temp;
					temp.prev.next = node;
					temp.prev = node;
					found = true;
					break;
				}
				temp = temp.next;
			}

			if (!found) {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
	}

	public Integer poll() {
		Node<Integer> temp = head;
		Integer value = temp.value;

		head = temp.next;
		temp.prev = null;

		return value;
	}

	public void print() {
		Node<Integer> temp = head;

		System.out.print(temp.value + " ");
		while (temp.next != null) {
			temp = temp.next;
			System.out.print(temp.value + " ");
		}
	}
}