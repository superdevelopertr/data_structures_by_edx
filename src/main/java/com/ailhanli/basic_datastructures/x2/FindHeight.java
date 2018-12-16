package com.ailhanli.basic_datastructures.x2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Tree<T> {
	T value;
	List<Tree<T>> childs = new ArrayList<>();

	public Tree(T value) {
		super();
		this.value = value;
	}

	public void addChild(Tree<T> child) {
		childs.add(child);
	}

	public boolean isLeaf() {
		return childs.size() == 0;
	}
}

public class FindHeight {
	
	public List<Integer> findValuesOfIndex(List<Integer> nodes, int value){
		return IntStream.range(0, nodes.size()).filter(i->i==-1).mapToObj(Integer::valueOf).collect(Collectors.toList());
	}

	public int heigth(Tree<Integer> tree) {
		if (tree.isLeaf()) {
			return 1;
		}

		int height = 1;
		Queue<Tree<Integer>> queue = new LinkedList<>();
		queue.offer(tree);

		while (!queue.isEmpty()) {
			Tree<Integer> temp = queue.poll();
			if (!temp.isLeaf()) {
				List<Tree<Integer>> childs = temp.childs;
				height++;

				for (Tree<Integer> child : childs) {
					queue.offer(child);
				}
			}
		}

		return height;

	}
}