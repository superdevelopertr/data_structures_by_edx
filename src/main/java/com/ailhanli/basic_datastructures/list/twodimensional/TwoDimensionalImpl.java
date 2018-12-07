package com.ailhanli.basic_datastructures.list.twodimensional;

public class TwoDimensionalImpl<T> implements TwoLinkedList<T> {

	static class Node<T> {
		protected T data;
		protected Node<T> nextHorizontal;
		protected Node<T> nextVertical;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNextHorizontal() {
			return nextHorizontal;
		}

		public void setNextHorizontal(Node<T> nextHorizontal) {
			this.nextHorizontal = nextHorizontal;
		}

		public Node<T> getNextVertical() {
			return nextVertical;
		}

		public void setNextVertical(Node<T> nextVertical) {
			this.nextVertical = nextVertical;
		}
	}

	private Node<T> head, tail;

	@Override
	public void push(int x, int y, T key) {
		
		
	}

}
