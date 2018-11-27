package com.ailhanli.list;

public class LinkedList<T> implements List<T> {

	static class Node<T> {
		private T data;
		private Node<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	private Node<T> head, tail;

	public Node<T> getTail() {
		return tail;
	}

	public T getHeadData() {
		if (head != null) {
			return head.data;
		}
		return null;
	}

	public T getTailData() {
		if (tail != null) {
			return tail.data;
		}
		return null;
	}

	@Override
	public void pushFront(T key) {
		if (head == null) {
			head = new Node<T>();
			head.setData(key);
			head.next = null;
			tail = head;
			return;
		} else {
			Node<T> newNode = new Node<T>();
			newNode.next = head;
			newNode.setData(key);

			head = newNode;
		}
	}

	@Override
	public T topFront() {
		return getHeadData();
	}

	@Override
	public T popFront() {
		T result = getHeadData();
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return result;
	}

	@Override
	public void pushBack(T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);

		if (tail == null) {
			head = tail = newNode;
			return;
		}

		newNode.next = tail;
		tail = newNode;
	}

	@Override
	public T topBack() {
		return getTailData();
	}

	@Override
	public T popBack() {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			T value = head.data;
			head = tail = null;
			return value;
		}

		Node<T> temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		T value = tail.data;
		temp.next = null;
		tail = temp;

		return value;
	}

	@Override
	public boolean find(T key) {
		if (head == null) {
			return false;
		}

		Node<T> temp = head;
		for (; temp.next != null; temp = temp.next) {
			if (temp.getData().equals(key)) {
				return true;
			}
		}
		if (temp.getData().equals(key)) {
			return true;
		}

		return false;
	}

	@Override
	public void erase(T key) {
		if (head == null) {
			return;
		}

		if (head.getData().equals(key)) {
			head = head.next;
			if (head == null) {
				tail = null;
				return;
			}
		}

		Node<T> before = head;
		for (Node<T> temp = head; temp.next != null; temp = temp.next) {
			if (temp.getData().equals(key)) {
				Node<T> willDelete = temp;
				before.next = willDelete.next;
				willDelete.next = null;
				break;
			}

			before = temp;
		}

	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public void addBefore(Node<T> node, T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}

		if (head.next == null) {
			newNode.next = head;
			head = newNode;
			return;
		}

		Node<T> temp = head;
		while (!temp.next.data.equals(node.data)) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = node;
	}

	@Override
	public void addAfter(Node<T> node, T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);

		if(head==null){
			head = newNode;
			return;
		}
		
		if(node.next==null && head==tail){
			node.next = newNode;
			return;
		}else if(node==tail){
			node.next = newNode;
			tail = node;
		}else{
			newNode.next = node.next;
			node.next = newNode;
		}
	}

	public void print() {
		Node<T> x = head;
		while (x != null) {
			System.out.print(x.getData());
			if (x.next != null) {
				System.out.print(" - ");
			}
			x = x.next;
		}
	}

}
