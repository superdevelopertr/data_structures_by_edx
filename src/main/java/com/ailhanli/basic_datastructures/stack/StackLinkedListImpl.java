package com.ailhanli.basic_datastructures.stack;

import com.ailhanli.basic_datastructures.list.List;

public class StackLinkedListImpl<T> implements Stack<T> {
	private List<T> list;
	
	public StackLinkedListImpl(List<T> list) {
		super();
		this.list = list;
	}

	@Override
	public void push(T t) {
		list.pushFront(t);
	}

	@Override
	public T top() {
		return list.topFront();
	}

	@Override
	public T pop() {
		return list.popFront();
	}

	@Override
	public boolean empty() {
		return list.empty();
	}
}