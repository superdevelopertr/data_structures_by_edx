package com.ailhanli.basic_datastructures.queue;

public class QueuePrimitiveArrayImpl<T> implements Queue<T> {

	private final static int SIZE = 100;

	private T[] elems = (T[]) new Object[SIZE];

	private int read, write;

	@Override
	public void enqueue(T element) throws Exception {
		
	}

	@Override
	public T dequeue() throws QueueEmpty {
		return null;
	}

	@Override
	public boolean empty() {
		return false;
	}

}
