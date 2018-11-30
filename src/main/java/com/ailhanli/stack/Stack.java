package com.ailhanli.stack;

public interface Stack<T> {
	void push(T t);
	T top();
	T pop();
	
	boolean empty();
}