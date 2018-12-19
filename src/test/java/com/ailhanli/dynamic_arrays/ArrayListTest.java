package com.ailhanli.dynamic_arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

	private ArrayList<Integer> myArrayList;

	@Before
	public void setup() {
		myArrayList = new ArrayList<>();
	}

	@Test
	public void test_size() {

		int size = myArrayList.size();

		assertEquals(0, size);
	}

	@Test(expected = IllegalAccessError.class)
	public void test_getElement() {

		myArrayList.get(10);
	}

	@Test
	public void test_addNewElement() {

		myArrayList.add(12);
		myArrayList.add(25);

		int value = myArrayList.get(0);
		assertEquals(12, value);
	}

	@Test
	public void test_() {

		myArrayList.add(12);
		myArrayList.add(25);

		int newValue = 40;
		myArrayList.set(0, newValue);

		int value = myArrayList.get(0);
		assertEquals(40, value);
	}

	@Test(expected = IllegalAccessError.class)
	public void test_removeLastElement() {
		myArrayList.add(12);
		myArrayList.add(25);
		myArrayList.add(45);

		myArrayList.remove(2);

		myArrayList.get(2);
	}
	
	@Test
	public void test_removeFirstElement() {
		myArrayList.add(12);
		myArrayList.add(25);
		myArrayList.add(45);

		myArrayList.remove(0);

		int value = myArrayList.get(0);
		assertEquals(25, value);
		assertEquals(2, myArrayList.size());
	}
	
	
	@Test
	public void test_removeMiddleElement() {
		myArrayList.add(12);
		myArrayList.add(25);
		myArrayList.add(45);

		myArrayList.remove(1);

		int secondElement = myArrayList.get(1);
		int firstElement = myArrayList.get(0);
		assertEquals(12, firstElement);
		assertEquals(45,secondElement);
	}
	
	
	@Test
	public void test_capacity() {
		for(int i=0;i<10;i++) {
			myArrayList.add(i);
		}
		
		assertEquals(10, myArrayList.size());
	}
}