package com.ailhanli.list;

public class LinkedList<T> implements ListE<T> {

	static class Node<T> {
		protected T data;
		protected Node<T> next;

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
		if (head == null) {
			return null;
		}
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
			head = tail = newNode;
			return;
		}

		if (head.data.equals(node.data)) {
			newNode.next = head;
			head = newNode;

		}

		if (head.next == null) {
			return;
		}

		Node<T> findNode = head;
		Node<T> backNode = head;
		while (findNode.next != null) {

			backNode = findNode;
			findNode = findNode.next;

			if (findNode.data.equals(node.data)) {
				backNode.next = newNode;
				newNode.next = findNode;
				break;
			}
		}

	}

	@Override
	public void addAfter(Node<T> node, T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);

		if (head == null) {
			head = tail = newNode;
			return;
		} else if (head.next == null) {
			newNode.next = head;
			head = tail = newNode;
		} else if (node == tail) {
			tail.next = newNode;
		} 
		else {
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

	public Node<T> getHead() {
		return head;
	}

	@Override
	public T find(int index) {
		if(head==null ) {
			throw new IndexOutOfBoundsException();
		}
		
		if(head.next==null && index>0) {
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		Node<T> temp = head;
		while(temp.next!=null) {
			temp= temp.next;
			i++;
			if(i==index) {
				return temp.data;
			}
		}
		
		
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public void add(int index, T key) {
		Node<T> newNode = new Node<>();
		newNode.setData(key);
		
		if((head==null || head.next==null)&& index>0) {
			throw new IndexOutOfBoundsException();
		}
	
		if(head==null || index==0) {
			newNode.next = head;
			head = newNode;	
			return;
		}
		
		int i = 0;
		Node<T> temp = head;
		while(temp.next!=null) {		
			if(++i==index) {
				break;
			}
			
			temp= temp.next;
		}
		
		if(i!=index) {
			throw new IndexOutOfBoundsException();
		}
		
		newNode.next = temp.next;
		temp.next = newNode;		
	}
}
