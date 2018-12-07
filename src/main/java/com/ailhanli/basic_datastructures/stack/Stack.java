package com.ailhanli.basic_datastructures.stack;

import com.ailhanli.basic_datastructures.list.LinkedList;

public interface Stack<T> {
	static <A> Stack<A> getInstance(){
		return new StackLinkedListImpl<A>(new LinkedList<>());
	}
	
	void push(T t);
	T top();
	T pop();
	
	boolean empty();
}