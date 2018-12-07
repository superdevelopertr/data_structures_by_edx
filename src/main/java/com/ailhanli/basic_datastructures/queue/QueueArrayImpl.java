package com.ailhanli.basic_datastructures.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueArrayImpl<T> implements Queue<T> {

	private List<T> list = new ArrayList<>();
	
	@Override
	public void enqueue(T element) {
		list.add(element);
	}

	@Override
	public T dequeue() {
		T elem = list.get(0);
		list.remove(0);
		return elem;
	}

	@Override
	public boolean empty() {
		return list.isEmpty();
	}
}