package com.ailhanli.stack.queue;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.ailhanli.basic_datastructures.queue.Queue;
import com.ailhanli.basic_datastructures.queue.QueuePrimitiveArrayImpl;


public class QueuePrimitiveArrayImplTest {


	@Test
	public void test_enqueu() throws Exception{
		Queue<String> queue = new QueuePrimitiveArrayImpl();
		queue.enqueue("passenger_1");
		
		fail("not implemented yet");
	}
}
