package com.ailhanli.basic_datastructures.x1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolveBracketProblemTest {

	@Test
	public void test_solveOneLetterIsIncorrect(){
		SolveBracketProblem sb = new SolveBracketProblem();
				
		assertEquals("1", sb.solve("("));
		assertEquals("1", sb.solve("["));
		assertEquals("1", sb.solve("{"));
	}
	
	@Test
	public void test_solveMoreLetterIsIncorrect(){
		SolveBracketProblem sb = new SolveBracketProblem();
				
		//assertEquals("2", sb.solve("(("));
		//assertEquals("3", sb.solve("(){"));
		assertEquals("10", sb.solve("(){][][({)]"));

	}
	

	@Test
	public void test_solveTwoLetterCorrect(){
		SolveBracketProblem sb = new SolveBracketProblem();
		
		assertEquals("0", sb.solve("()"));
		assertEquals("0", sb.solve("(())()"));
	}
}
