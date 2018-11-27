package com.ailhanli.list;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ailhanli.list.LinkedList;
import com.ailhanli.list.LinkedList.Node;

public class LinkedListTest {

	@Test
	public void test_pushFront(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		
		assertEquals("B",list.getHeadData());		
	}
	
	
	@Test
	public void test_topFront(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		
		assertEquals("A",list.topFront());
	}

	
	@Test
	public void test_popFront(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		
		assertEquals("B",list.popFront());
	}
	
	@Test
	public void test_pushBack(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		
		list.pushBack("C");
		
		assertEquals("C",list.getTailData());
	}
	
	@Test
	public void test_topBack(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		
		assertEquals("A",list.topBack());
	}
	
	@Test
	public void test_popBack(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		
		assertEquals("A",list.popBack());
		assertEquals("B",list.topFront());

	}
	
	@Test
	public void test_find(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		assertTrue(list.find("C"));
	}
	

	@Test
	public void test_Notfind(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		assertFalse(list.find("X"));
	}
	
	@Test
	public void test_delete(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		list.erase("B");
		
		assertEquals("C", list.getHeadData());
		
		list.erase("C");
		assertEquals("A", list.getHeadData());
	}
	
	@Test
	public void test_empty(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		
		assertFalse(list.empty());
	}
	
	@Test
	public void test_addBefore(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		Node<String> tail = list.getTail();
		
		list.addBefore(tail, "X");
		
		assertTrue(list.find("X"));
		
	}
	

	@Test
	public void test_addAfter(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		Node<String> tail = list.getTail();
		
		list.addAfter(tail, "X");
		assertTrue(list.find("X"));
	}

}
