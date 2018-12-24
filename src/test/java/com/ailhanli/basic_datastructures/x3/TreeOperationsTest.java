package com.ailhanli.basic_datastructures.x3;

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
	
}