package com.ailhanli.basic_datastructures.tree.btree;

public class BT<T> {
	
	BT<T> left;
	BT<T> right;
	T value;
	
	public BT(T value) {
		this.value = value;
	}
}