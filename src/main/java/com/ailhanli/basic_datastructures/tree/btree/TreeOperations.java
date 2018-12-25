package com.ailhanli.basic_datastructures.tree.btree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {

	public static void buildTree(BT<Integer> b, Integer... numbers) {
		for (Integer n : numbers) {
			buildTree(b, n);
		}
	}

	public static void buildTree(BT<Integer> b, Integer number) {
		if (b == null) {
			new BT<>(number);
			return;
		}

		if (b.left == null && b.value >= number) {
			BT<Integer> newNode= new BT<>(number);
			newNode.parent=b;
			b.left = newNode;
			return;
		}

		if (b.right == null && b.value < number) {
			BT<Integer> newNode= new BT<>(number);
			newNode.parent=b;
			b.right = newNode;
			return;
		}

		if (b.value >= number) {
			buildTree(b.left, number);
		} else {
			buildTree(b.right, number);
		}
	}
	
	
	public static void remove(BT<Integer> b, Integer number){
		if(b.value==number){
			if(b.parent!=null){
				System.out.println("parent: "+b.parent.getValue());
			}
			if(b.left!=null){
				System.out.println("left: "+b.left.getValue());
			}
			if(b.right!=null){
				System.out.println("right: "+b.right.getValue());
			}
			return;
		}
		
		remove(b.left, number);
		remove(b.right, number);
	}

}