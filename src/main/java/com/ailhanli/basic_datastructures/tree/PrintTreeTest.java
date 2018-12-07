package com.ailhanli.basic_datastructures.tree;

import com.ailhanli.basic_datastructures.queue.Queue;
import com.ailhanli.basic_datastructures.queue.QueueEmpty;
import com.ailhanli.basic_datastructures.queue.QueueLinkedListImpl;

public class PrintTreeTest {

	public static BinaryTree<Integer> createBinaryTree() {

		BinaryTree<Integer> n1 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> n2 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> n3 = new BinaryTree<Integer>(18);
		BinaryTree<Integer> n4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> n5 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> n6 = new BinaryTree<Integer>(15);
		BinaryTree<Integer> n7 = new BinaryTree<Integer>(21);

		n1.setLeft(n2);
		n2.setLeft(n4);
		n2.setRight(n5);
		n1.setRight(n3);
		n3.setLeft(n6);
		n3.setRight(n7);

		return n1;
	}

	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> binaryTree = createBinaryTree();

		//printDFS(binaryTree);
		printBFS(binaryTree);
	}

	public static void printDFS(BinaryTree<Integer> binaryTree) {
		if (binaryTree == null) {
			return;
		}

		printDFS(binaryTree.getLeft());
		printDFS(binaryTree.getRight());
		System.out.println(binaryTree.getValue());
	}

	public static void printBFS(BinaryTree<Integer> binaryTree) throws Exception {

		Queue<BinaryTree<Integer>> queue = new QueueLinkedListImpl<>();
		queue.enqueue(binaryTree);
		
		printBFS(queue);
	}

	public static void printBFS(Queue<BinaryTree<Integer>> queue) throws Exception {
		
		while(!queue.empty()){
			BinaryTree<Integer> bTree =queue.dequeue();
			System.out.print(bTree.getValue()+" ");
			
			if(bTree.getLeft()!=null){
				queue.enqueue(bTree.getLeft());
			}
			
			if(bTree.getRight()!=null){
				queue.enqueue(bTree.getRight());
			}
		}
		
	}

}
