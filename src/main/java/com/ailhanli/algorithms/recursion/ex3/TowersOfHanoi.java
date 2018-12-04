package com.ailhanli.algorithms.recursion.ex3;


//https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
public class TowersOfHanoi {

	static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		if (n == 1) {
			System.out.println("Moving disk 1 from "+from_rod+" to "+to_rod);
			return;
		}
		
		towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
		System.out.println("moving disk"+n+" from "+from_rod+"  to "+to_rod);
		towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
	}
	
	
	public static void main(String[] args) {

		int n = 4; // Number of disks
		towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
	}
}
