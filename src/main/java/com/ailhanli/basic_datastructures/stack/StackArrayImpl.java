package com.ailhanli.basic_datastructures.stack;

import java.util.ArrayList;
import java.util.List;

public class StackArrayImpl<T> implements Stack<T> {

	private List<T> data = new ArrayList<>();

	@Override
	public void push(T t) {
		data.add(t);
	}

	@Override
	public T top() {
		return data.get(data.size()-1);
	}

	@Override
	public T pop() {
		T t = data.get(data.size()-1);
		data.remove(data.size()-1);
		return t;
	}

	@Override
	public boolean empty() {
		return data.isEmpty();
	}
}