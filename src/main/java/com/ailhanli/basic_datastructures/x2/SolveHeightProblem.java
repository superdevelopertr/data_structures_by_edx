package com.ailhanli.basic_datastructures.x2;

import java.util.List;

import com.ailhanli.basic_datastructures.queue.Queue;
import com.ailhanli.basic_datastructures.queue.QueueArrayImpl;
import com.ailhanli.basic_datastructures.queue.QueueLinkedListImpl;
import com.ailhanli.basic_datastructures.tree.Tree;

public class SolveHeightProblem {

	public static Tree<Integer> buildTree(Tree<Integer> tree, Tree<Integer> temp, int[] nodes, int value) {
		int nextValue = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == -1 && tree == null) {
				temp = new Tree<Integer>(i);
				nextValue = i;
				tree = temp;
				buildTree(tree, temp, nodes, nextValue);
			} else if (nodes[i] == value) {

				Tree<Integer> newChild = new Tree<Integer>(i);
				temp.addChild(newChild);
				buildTree(tree, newChild, nodes, i);
			}
		}

		return tree;
	}

	public static int findSubHeight(Tree<Integer> tree) {
		List<Tree<Integer>> childs = tree.getChilds();
		if (childs == null) {
			return 0;
		}

		int max = 0;
		for (Tree<Integer> child : childs) {
			int height = 1 + findSubHeight(child);
			if (height > max) {
				max = height;
			}
		}

		return max;
	}

	public static int findHeight(Queue<Tree<Integer>> queue) throws Exception {

		int height = 0;
		while (!queue.empty()) {
			Tree<Integer> temp = queue.dequeue();
			List<Tree<Integer>> childs = temp.getChilds();
			if (childs != null) {
				for (Tree<Integer> child : childs) {
					queue.enqueue(child);
				}
				height++;
			}
		}
		
		return height;
	}

	public static int findHeight(int[] numbers) throws Exception {
		Tree<Integer> tree = null;
		Tree<Integer> temp = null;
		tree = buildTree(tree, temp, numbers, -1);
		Queue<Tree<Integer>> queue = new QueueArrayImpl<>();
		queue.enqueue(tree);

		int height = findHeight(queue);
		return height + 1;
	}
}