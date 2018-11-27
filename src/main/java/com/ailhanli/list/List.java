package com.ailhanli.list;

import com.ailhanli.list.LinkedList.Node;

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
	 
	 void addBefore(Node<T> node, T key);
	 void addAfter(Node<T> node, T key);
}
