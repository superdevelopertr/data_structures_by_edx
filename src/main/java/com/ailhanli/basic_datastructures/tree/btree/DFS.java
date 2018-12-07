package com.ailhanli.basic_datastructures.tree.btree;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	public void print(BT<Integer> b) {
		Stack<BT<Integer>> stack = new Stack<>();
		stack.push(b);
		print(stack);
		
	}
	public void print(Stack<BT<Integer>> stack) {
		while(!stack.isEmpty()) {
			BT<Integer> b = stack.pop();
			System.out.print(b.value+" ");
		
			if(b.right!=null) {
				stack.push(b.right);
			}
			
			if(b.left!=null) {
				stack.push(b.left);
			}
		}
	}
	
	
	public void printDFS1(BT<Integer> b) {
		if (b == null) {
			return;
		}

		printDFS1(b.left);
		System.out.print(b.value + " ");
		printDFS1(b.right);
	}

	public void printDFS2(BT<Integer> b) {
		if (b == null) {
			return;
		}

		System.out.print(b.value + " ");
		printDFS1(b.left);
		printDFS1(b.right);
	}

	public void printDFS3(BT<Integer> b) {
		if (b == null) {
			return;
		}

		printDFS1(b.left);
		printDFS1(b.right);
		System.out.print(b.value + " ");
	}
}