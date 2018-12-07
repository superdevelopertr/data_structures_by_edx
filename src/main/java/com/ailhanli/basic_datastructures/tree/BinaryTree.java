package com.ailhanli.basic_datastructures.tree;

public class BinaryTree<T> {

	private BinaryTree<T> left;

	private BinaryTree<T> right;

	private T value;

	public BinaryTree(T value) {
		super();
		this.value = value;
	}
	
	public void setLeft(BinaryTree<T> left) {
		this.left = left;
	}
	public void setRight(BinaryTree<T> right) {
		this.right = right;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public T getValue() {
		return value;
	}
}
