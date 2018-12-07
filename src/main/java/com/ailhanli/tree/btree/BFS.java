package com.ailhanli.tree.btree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void prinfBFS(BT<Integer> b) {
		Queue<BT<Integer>> queue = new LinkedList<>();
		queue.offer(b);
		
		print(queue);
	}
	
	public void print(Queue<BT<Integer>> q) {
		//Queue<Integer> q = new LinkedList<>(); 
		
		while(!q.isEmpty()) {
			BT<Integer> b = q.poll();
			System.out.println(b.value+" ");
			
			if(b.left!=null) {
				q.offer(b.left);
			}
			
			if(b.right!=null) {
				q.offer(b.right);
			}
		}
	}
}