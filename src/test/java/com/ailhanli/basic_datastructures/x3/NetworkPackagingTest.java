package com.ailhanli.basic_datastructures.x3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NetworkPackagingTest {

	private NetworkPackaging np = new NetworkPackaging();
	
	@Test
	public void test_noItems(){
		List<String> elems = Arrays.asList("1 0");
		
		assertNull(np.simulate(elems));
	}
	

	@Test
	public void test_OneItem(){
		List<String> elems = Arrays.asList("1 1", "0 0");
		
		assertArrayEquals(new int[]{0}, np.simulate(elems));
	}
	
}
