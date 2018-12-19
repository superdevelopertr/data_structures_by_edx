package com.ailhanli.basic_datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private T value;
	
	private List<Tree<T> > childs;

	public Tree(T value) {
		super();
		this.value = value;
	}
	
	public void addChild(Tree<T> newChild) {
		if(childs==null) {
			childs = new ArrayList<>();
		}
		childs.add(newChild);
	}
	
	public T getValue() {
		return value;
	}
	
	public List<Tree<T>> getChilds() {
		return childs;
	}
}