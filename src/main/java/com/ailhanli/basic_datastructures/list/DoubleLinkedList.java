package com.ailhanli.basic_datastructures.list;

public class DoubleLinkedList<T> implements List<T> {

	static class Node<T> extends LinkedList.Node<T> {
		private Node<T> prev;

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

	}

	private Node<T> head;

	private Node<T> tail;

	@Override
	public void pushFront(T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);

		if (head == null) {
			tail = head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	@Override
	public T topFront() {
		if (head != null) {
			return head.data;
		}
		return null;
	}

	@Override
	public T popFront() {
		if (head == null) {
			return null;
		}

		T headData = head.getData();

		if (head.next == null) {
			head = tail = null;
			return headData;
		}

		head = (Node<T>) head.next;
		head.setPrev(null);

		return headData;
	}

	@Override
	public void pushBack(T key) {
		Node<T> newNode = new Node<>();
		newNode.data = key;

		if (tail == null) {
			tail = head = newNode;
		} else {
			newNode.next = tail;
			tail.prev = newNode;
			tail = newNode;
		}
	}

	@Override
	public T topBack() {
		if(tail!=null) {
			return tail.getData();
		}
		
		return null;
	}

	@Override
	public T popBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean find(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void erase(T key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	public T getHeadData() {
		if (head != null) {
			return head.getData();
		}
		return null;
	}

	public T getTailData() {
		if (tail != null) {
			return tail.getData();
		}
		return null;
	}
}
