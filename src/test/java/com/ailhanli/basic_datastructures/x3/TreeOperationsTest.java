package com.ailhanli.basic_datastructures.x3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.ailhanli.basic_datastructures.tree.Tree;

public class TreeOperationsTest {

	private TreeOperations operations = new TreeOperations();
		
	
	@Test
	public void test_removeRoot() {
		Tree<Integer> tree = new Tree<Integer>(10);
		tree = operations.remove(tree, 10);
		assertNull(tree);
	}
	
	@Test(expected = IllegalAccessError.class)
	public void test_removeElementNotFound() {
		Tree<Integer> tree = new Tree<Integer>(10);
		tree = operations.remove(tree, 23);
	}
	
	@Test
	public void test_removeOneLevelChild() {
		Tree<Integer> tree = new Tree<Integer>(10);
		Tree<Integer> c1 = new Tree<Integer>(8);
		c1.setParent(tree);
		Tree<Integer> c2 = new Tree<Integer>(6);
		c2.setParent(tree);
		Tree<Integer> c3 = new Tree<Integer>(7);
		c3.setParent(tree);
		Tree<Integer> c4 = new Tree<Integer>(19);
		c4.setParent(tree);
		
		tree.addChild(c1);
		tree.addChild(c2);
		tree.addChild(c3);
		tree.addChild(c4);
		
		tree = operations.remove(tree, 8);
		tree = operations.remove(tree, 7);
		assertEquals(2, tree.getChilds().size());
	}
	
	@Test
	public void test_noReplacement(){
		Tree<Integer> tree = new Tree<Integer>(10);
		Tree<Integer> c1 = new Tree<Integer>(8);
		c1.setParent(tree);
		Tree<Integer> c2 = new Tree<Integer>(6);
		c2.setParent(tree);
		Tree<Integer> c3 = new Tree<Integer>(7);
		c3.setParent(tree);
		Tree<Integer> c4 = new Tree<Integer>(19);
		c4.setParent(tree);
		
		tree = operations.replace(tree, 10, 10);
		assertEquals(Integer.valueOf(10), tree.getValue());
	}
	
	@Test
	public void test_replaceRootWithChild(){
		Tree<Integer> tree = new Tree<Integer>(10);
		Tree<Integer> c1 = new Tree<Integer>(8);
		c1.setParent(tree);
		Tree<Integer> c2 = new Tree<Integer>(6);
		c2.setParent(tree);
		Tree<Integer> c3 = new Tree<Integer>(7);
		c3.setParent(tree);
		Tree<Integer> c4 = new Tree<Integer>(19);
		c4.setParent(tree);
		
		tree.addChild(c1);
		tree.addChild(c2);
		tree.addChild(c3);
		tree.addChild(c4);
		
		tree = operations.replace(tree, 10, 8);
		assertEquals(Integer.valueOf(8), tree.getValue());
	}
	
	
	@Test
	public void test_replaceChildWithChild(){
		Tree<Integer> tree = new Tree<Integer>(10);
		Tree<Integer> c1 = new Tree<Integer>(8);
		c1.setParent(tree);
		Tree<Integer> c2 = new Tree<Integer>(6);
		c2.setParent(tree);
		Tree<Integer> c3 = new Tree<Integer>(7);
		c3.setParent(tree);
		Tree<Integer> c4 = new Tree<Integer>(19);
		c4.setParent(c3);
		c3.addChild(c4);
		
		tree.addChild(c1);
		tree.addChild(c2);
		tree.addChild(c3);
		
		tree = operations.replace(tree, 7, 19);
		assertEquals(Integer.valueOf(8), tree.getValue());
	}
	
}