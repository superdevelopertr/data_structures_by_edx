package com.ailhanli.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.ailhanli.basic_datastructures.list.DoubleLinkedList;

public class DoubleLinkedListTest {

	@Test
	public void test_pushFront() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		
		dl.pushFront("A");
		assertEquals("A", dl.getHeadData());
		
		dl.pushFront("B");
		assertEquals("B", dl.getHeadData());
		assertEquals("A", dl.getTailData());
		
		dl.pushFront("C");
		assertEquals("C", dl.getHeadData());
		assertEquals("A", dl.getTailData());
	}
	
	@Test
	public void test_topFront() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		
		dl.pushFront("A");
		assertEquals("A", dl.topFront());
		
		dl.pushFront("B");
		assertEquals("B", dl.topFront());
		
	}
	
	@Test
	public void test_empty_popFront() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		assertNull( dl.popFront());
	}
	
	@Test
	public void test_oneElement_popFront() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		dl.pushFront("A");
		assertEquals("A", dl.popFront());
		assertNull( dl.popFront());
		
		dl.pushFront("B");
		dl.pushFront("C");
		dl.pushFront("D");
		assertEquals("D", dl.popFront());
		assertEquals("C", dl.getHeadData());
		assertEquals("B", dl.getTailData());
		
	}
	
	@Test
	public void test_moreElement_popFront() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();

		dl.pushFront("B");
		dl.pushFront("C");
		dl.pushFront("D");
		assertEquals("D", dl.popFront());
		assertEquals("C", dl.getHeadData());
		assertEquals("B", dl.getTailData());
		
	}
	
	@Test
	public void test_emptyList_pushBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		
		dl.pushBack("A");
		
		assertEquals( "A", dl.getTailData());
	}
	
	@Test
	public void test_to1elementlist_pushBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		dl.pushFront("A");
		
		dl.pushBack("B");
		
		assertEquals("B", dl.getTailData());
	}
	
	
	@Test
	public void test_toMoreelementlist_pushBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		dl.pushFront("A");
		dl.pushFront("B");
		
		dl.pushBack("C");
		
		assertEquals("C", dl.getTailData());
	}
	
	@Test
	public void test_emptyList_topBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		assertNull( dl.topBack());
	}
	
	@Test
	public void test_nonEmpty_topBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		dl.pushBack("A");
		dl.pushBack("B");
		dl.pushBack("C");
		
		assertEquals("C", dl.topBack());
	}
	
	@Test
	public void test_empty_popBack() {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		assertNull( dl.topBack());
	}
}