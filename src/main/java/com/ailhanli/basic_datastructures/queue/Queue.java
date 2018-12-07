package com.ailhanli.basic_datastructures.queue;

public interface Queue<T> {

	static <T> Queue<T> getInstance(QueueType type) {
		switch (type) {
		case LINKED_LIST:
			return new QueueLinkedListImpl<>();
		case ARRAY:
			return new QueueLinkedListImpl<>();
		}
		
		return null;
	}

	void enqueue(T element) throws Exception;

	T dequeue() throws QueueEmpty;

	boolean empty();
}