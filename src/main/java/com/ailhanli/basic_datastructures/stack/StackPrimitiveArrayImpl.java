package com.ailhanli.basic_datastructures.stack;

public class StackPrimitiveArrayImpl<T> implements Stack<T> {

	private final static int SIZE = 100;

	private T[] elems = (T[]) new Object[SIZE];

	private int read, write;

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}
}
