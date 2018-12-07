package com.ailhanli.tree.btree;

public class Test {

	public static void main(String[] args) {
		
		DFS d = new DFS();
		
		BT<Integer> b = new BT<>(10);
		BuildBT.addAllNodes(b, 6,18,4,8,15,21);
		
//		System.out.print("DFS in order: ");
//		d.printDFS1(b);
//		
//		System.out.println();
//		System.out.print("DFS in pre: ");
//		d.printDFS2(b);
//		
//		System.out.println();
//		System.out.print("DFS in pro: ");
//		d.printDFS3(b);
		
		BFS bfs = new BFS();
		//bfs.prinfBFS(b);
		
		d.print(b);
		
	}
}
