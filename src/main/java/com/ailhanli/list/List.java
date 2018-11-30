package com.ailhanli.list;

public interface List<T> {

	 void pushFront(T key);
	 T topFront();
	 T popFront();
	 
	 void pushBack(T key);
	 T topBack();
	 T popBack();
	 
	 boolean find(T key);
	 void erase(T key);
	 boolean empty();
}