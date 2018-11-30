package com.ailhanli.list;

import com.ailhanli.list.LinkedList.Node;

public interface ListE<T> extends List<T>{

	 void addBefore(Node<T> node, T key);
	 void addAfter(Node<T> node, T key);
	 
	 void add(int index, T key);
	 T find(int index);	 
}
