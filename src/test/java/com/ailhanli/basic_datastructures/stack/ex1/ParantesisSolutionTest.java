package com.ailhanli.basic_datastructures.stack.ex1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ailhanli.basic_datastructures.stack.ex1.ParantesisSolution;

public class ParantesisSolutionTest {

	@Test
	public void test_emptyStack_isNotBalanced() {
		ParantesisSolution solution = new ParantesisSolution();
				
		assertFalse(solution.isBalanced("(("));
		
		assertFalse(solution.isBalanced("((())"));
	}
	
	
	@Test
	public void test_emptyStack_isBalanced() {
		ParantesisSolution solution = new ParantesisSolution();
				
		assertTrue(solution.isBalanced("()"));
		assertTrue(solution.isBalanced("((()))"));
		
		assertTrue(solution.isBalanced("(([]))[]()"));
	}

}