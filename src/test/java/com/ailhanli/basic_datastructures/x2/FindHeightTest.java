package com.ailhanli.basic_datastructures.x2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindHeightTest {

	private FindHeight fh = new FindHeight();
	
	@Test
	public void test_findHeightOne(){
		
		Tree<Integer> tree = new Tree<>(3);
		
		assertEquals(1, fh.heigth(tree));
	}
	
	@Test
	public void test_findHeightTwo(){
		
		Tree<Integer> tree = new Tree<>(3);
		Tree<Integer> node = new Tree<>(1);
		tree.addChild(node);
		
		assertEquals(2, fh.heigth(tree));
	}
	
	@Test
	public void test_findHeightThree(){
		
		Tree<Integer> tree = new Tree<>(3);
		Tree<Integer> node = new Tree<>(1);
		Tree<Integer> node2 = new Tree<>(1);
		node.addChild(node2);
		tree.addChild(node);
		
		assertEquals(3, fh.heigth(tree));
	}
}