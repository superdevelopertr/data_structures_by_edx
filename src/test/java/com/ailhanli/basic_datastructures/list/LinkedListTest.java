package com.ailhanli.basic_datastructures.list;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ailhanli.basic_datastructures.list.LinkedList;
import com.ailhanli.basic_datastructures.list.LinkedList.Node;

public class LinkedListTest {

	@Test
	public void test_pushFront(){
		LinkedList<String> list = new LinkedList<>();
		
		list.pushFront("A");
		assertEquals("A",list.getHeadData());		
		
		list.pushFront("B");
		assertEquals("B",list.getHeadData());		
		
		
		list.pushFront("C");
		assertEquals("C",list.getHeadData());	
	}
	
	
	@Test
	public void test_topFront(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		
		assertEquals("A",list.topFront());
		
		list.pushFront("B");
		assertEquals("B",list.topFront());
	}

	
	@Test
	public void test_popFront(){
		LinkedList<String> list = new LinkedList<>();
		assertNull(list.popFront());
		
		list.pushFront("A");
		assertEquals("A",list.popFront());
		
		list.pushFront("A");
		list.pushFront("B");
		assertEquals("B",list.popFront());
		
	}
	
	@Test
	public void test_pushBack(){
		LinkedList<String> list = new LinkedList<>();
		
		list.pushBack("C");
		assertEquals("C",list.getTailData());
		
		list.pushBack("X");
		assertEquals("X",list.getTailData());

	}
	
	@Test
	public void test_topBack(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		assertEquals("A",list.topBack());
		
		list.pushBack("X");
		assertEquals("X",list.topBack());
	}
	
	@Test
	public void test_popBack(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");

		assertEquals("A",list.popBack());
		assertEquals("B",list.popBack());
		
		list.pushFront("X");
		assertEquals("C",list.popBack());
	}
	
	@Test
	public void test_find(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		assertTrue(list.find("C"));
		assertFalse(list.find("X"));
	}
	
	@Test
	public void test_delete(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		list.erase("C");
		assertEquals("B", list.getHeadData());
		
		list.erase("A");
		assertEquals("B", list.getHeadData());
	}
	
	@Test
	public void test_empty(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		
		assertFalse(list.empty());
		
		list.popFront();
		assertTrue(list.empty());
	}
	
	@Test
	public void test_addBefore(){
		LinkedList<String> list = new LinkedList<>();
		Node<String> tail = list.getTail();
		
		list.addBefore(tail, "X");
		assertTrue(list.find("X"));
		
		list.pushFront("A");
		list.pushFront("B");
		
		Node<String> head = list.getHead();
		list.addBefore(head, "Y");
		assertTrue(list.find("Y"));
		assertEquals("Y", list.getHeadData());
		assertEquals("X", list.getTailData());

	}
	

	@Test
	public void test_addAfter(){
		LinkedList<String> list = new LinkedList<>();
		Node<String> tail = list.getTail();
		
		
		list.addAfter(tail, "X");
		assertTrue(list.find("X"));
		
		list.addAfter(tail, "Y");
		assertEquals("Y",list.topBack());
		
		Node<String> head = list.getHead();
		
		list.addAfter(head, "Z");
		assertTrue(list.find("Z"));
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void test_find_by_index_not_found_elem(){
		LinkedList<String> list = new LinkedList<>();
		assertEquals("B", list.find(0));;
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void test_find_by_index_not_found_elem_one_element(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		assertEquals("B", list.find(1));;
	}
	
	@Test
	public void test_find_by_index(){
		LinkedList<String> list = new LinkedList<>();
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
	
		assertEquals("B", list.find(1));;
		
		list.pushFront("D");
		assertEquals("B", list.find(2));;
	}

	
	@Test(expected= IndexOutOfBoundsException.class)
	public void test_add_wrong_index(){
		LinkedList<String> list = new LinkedList<>();
		list.add(1, "K");
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void test_add_wrong_index_2(){
		LinkedList<String> list = new LinkedList<>();
		
		list.pushFront("A");
		list.add(3, "K");
	}
	
	@Test
	public void test_add_first_index(){
		LinkedList<String> list = new LinkedList<>();		
		list.add(0, "K");
		
		assertEquals("K", list.getHeadData());
	}
	
	@Test
	public void test_add_first_index_2(){
		LinkedList<String> list = new LinkedList<>();		
		list.pushFront("A");
		list.add(0, "K");
		
		assertEquals("K", list.getHeadData());
	}
	
	
	@Test
	public void test_add_good_index(){
		LinkedList<String> list = new LinkedList<>();		
		list.pushFront("A");
		list.pushFront("B");
		list.pushFront("C");
		
		list.add(1, "K");
		assertEquals("K", list.find(1));

		list.add(3, "X");
		assertEquals("X", list.find(3));
	}
}
