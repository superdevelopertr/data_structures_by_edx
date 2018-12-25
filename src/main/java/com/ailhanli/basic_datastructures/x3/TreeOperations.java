package com.ailhanli.basic_datastructures.x3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ailhanli.basic_datastructures.tree.Tree;

public class TreeOperations {

	public Tree<Integer> remove(Tree<Integer> tree, Integer number) {
		boolean find = false;
		if (tree.getValue() == number) {
			List<Tree<Integer>> childs = tree.getChilds();

			if (childs == null || childs.size() == 0) {
				return null;
			} else {
				Tree<Integer> newRoot = childs.get(0);
				newRoot.setParent(null);
				newRoot.setChilds(tree.getChilds());
				tree = newRoot;
			}
			find = true;
		}

		Queue<Tree<Integer>> queue = new LinkedList<>();
		queue.add(tree);

		while (!queue.isEmpty()) {
			Tree<Integer> node = queue.poll();
			List<Tree<Integer>> childs = node.getChilds();

			if (childs != null) {
				for (int i = 0; i < childs.size(); i++) {
					Tree<Integer> child = childs.get(i);

					if (child.getValue() == number) {
						find = true;
						childs.remove(i);
						if (child.getChilds() != null) {
							for (Tree<Integer> childOfChild : child.getChilds()) {
								childOfChild.setParent(child.getParent());
							}

						}
						child.setParent(null);
						return tree;
					}
				}
			}
		}

		if (!find) {
			throw new IllegalAccessError();
		}

		return null;
	}
}