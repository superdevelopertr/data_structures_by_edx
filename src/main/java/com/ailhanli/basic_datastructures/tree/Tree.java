package com.ailhanli.basic_datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private T value;
	
	private Tree<T> parent;
	
	private List<Tree<T> > childs;

	public Tree(T value) {
		super();
		this.value = value;
	}
	
	public void setChilds(List<Tree<T>> childs) {
		this.childs = childs;
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
	
	public void setParent(Tree<T> parent) {
		this.parent = parent;
	}
	
	public Tree<T> getParent() {
		return parent;
	}
}