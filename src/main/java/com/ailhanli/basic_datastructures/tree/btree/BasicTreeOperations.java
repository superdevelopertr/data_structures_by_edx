package com.ailhanli.basic_datastructures.tree.btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ailhanli.basic_datastructures.tree.Tree;

public class BasicTreeOperations {

	public static void main(String[] args) {
		Tree<Integer> tree = createTree();
		//tree= replace(tree, 2, 6);

		//7 2 5 9 4 
		tree = remove(tree,2,5,11,6);
		
//		remove(tree, 5);
//		remove(tree, 11);
//		remove(tree, 6);
//		
//		tree = remove(tree, 2);
		
		print(tree);

	}

	public static Tree<Integer> remove(Tree<Integer> tree , Integer... numbers){
		for(Integer number: numbers){
			tree= remove(tree, number);
		}
		return tree;
	}
	
	public static Tree<Integer> remove(Tree<Integer> c , int number){
		Tree<Integer> result = c;
		
		Tree<Integer> node = findNode(c, number);
		
		if(node.hasChilds()){
			if(node.getParent()==null){
				Tree<Integer> anyChild = node.getChilds().get(0);
				node.remove(anyChild);
				node.getChilds().forEach(n->n.setParent(anyChild));
				anyChild.setParent(null);
				node.getChilds().forEach(anyChild::addChild);
				result = anyChild;
			}else{
				Tree<Integer> parent = node.getParent();
				parent.remove(node);
				node.getChilds().forEach(parent::addChild);
			}
		}else{
			if(node.getParent()==null){
				return null;
			}
			
			Tree<Integer> parent = node.getParent();
			node.setParent(null);
			parent.remove(node);
		}
		
		return result;
	}
	
	public static Tree<Integer>  replace(Tree<Integer> c, int n1, int n2) {
		Tree<Integer> result = c;
		
		Tree<Integer> f = findNode(c, n1);
		Tree<Integer> s = findNode(c, n2);

		List<Tree<Integer>> fc = f.getChilds();
		List<Tree<Integer>> sc = s.getChilds();

		if (sc != null) {
			sc.stream().forEach(x -> x.setParent(f));
		}
		if (fc != null) {
			fc.stream().forEach(x -> x.setParent(s));
		}

		if (f.getParent() != null) {
			f.getParent().remove(f);
			f.getParent().addChild(s);
		}else{
			result= s;
		}

		if (s.getParent() != null) {
			s.getParent().remove(s);
			s.getParent().addChild(f);
		}else{
			result= f;
		}

		f.setParent(s.getParent());
		s.setParent(f.getParent());

		f.setChilds(sc);
		s.setChilds(fc);
		
		return result;
	}

	public static Tree<Integer> createTree() {
		Tree<Integer> c = new Tree<Integer>(2);
		Tree<Integer> c9 = new Tree<Integer>(2);

		Tree<Integer> c1 = new Tree<Integer>(7);
		Tree<Integer> c2 = new Tree<Integer>(5);
		Tree<Integer> c3 = new Tree<Integer>(2);
		Tree<Integer> c4 = new Tree<Integer>(6);
		Tree<Integer> c5 = new Tree<Integer>(9);
		Tree<Integer> c6 = new Tree<Integer>(5);
		Tree<Integer> c7 = new Tree<Integer>(11);
		Tree<Integer> c8 = new Tree<Integer>(4);
		c8.setParent(c5);
		c5.addChild(c8);
		c5.setParent(c2);
		c2.addChild(c5);
		c2.setParent(c3);
		c3.addChild(c2);

		c6.setParent(c4);
		c7.setParent(c4);
		c4.addChild(c6);
		c4.addChild(c7);
		c4.setParent(c1);
		c9.setParent(c1);
		c1.addChild(c4);
		c1.addChild(c9);

		c1.setParent(c);
		c2.setParent(c);
		c.addChild(c1);
		c.addChild(c2);
		return c;
	}

	public static void print(Tree<Integer> c) {
		Queue<Tree<Integer>> queue = new LinkedList<>();
		queue.offer(c);

		while (!queue.isEmpty()) {
			Tree<Integer> node = queue.poll();
			System.out.print(node.getValue() + " ");
			if (node.getChilds() != null) {
				node.getChilds().forEach(queue::offer);
			}
		}
	}

	public static Tree<Integer> findNode(Tree<Integer> tree, int value) {
		Queue<Tree<Integer>> queue = new LinkedList<>();
		queue.offer(tree);
		while (!queue.isEmpty()) {
			Tree<Integer> node = queue.poll();
			if (node.getValue() == value) {
				return node;
			}

			if (node.getChilds() != null) {
				node.getChilds().forEach(queue::offer);
			}
		}

		return null;
	}
}
