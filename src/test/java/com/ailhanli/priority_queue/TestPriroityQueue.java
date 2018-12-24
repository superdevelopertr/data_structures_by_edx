package com.ailhanli.priority_queue;

public class TestPriroityQueue {

	
	public static void main(String[] args) {
		
		PriorityQueue pq = new PriorityQueue();
		pq.push(1);		
		pq.push(3);
		pq.push(4);
		pq.push(2);
		pq.push(100);
		pq.push(99);
		pq.push(98);
		
		System.out.println();
		pq.poll();
		pq.poll();
		pq.print();
	}
}
