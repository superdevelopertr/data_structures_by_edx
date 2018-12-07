package com.ailhanli.basic_datastructures.queue;

import com.ailhanli.basic_datastructures.list.LinkedList;
import com.ailhanli.basic_datastructures.list.List;

public class QueueLinkedListImpl<T> implements Queue<T> {
	private List<T> list = new LinkedList<>();
	
	@Override
	public void enqueue(T element) {
		list.pushBack(element);
	}

	@Override
	public T dequeue() {
		return list.popFront();
	}

	@Override
	public boolean empty() {
		return list.empty();
	}
}
