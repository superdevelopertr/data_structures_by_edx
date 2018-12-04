package com.ailhanli.algorithms.recursion.ex2;

public class FindGCD {

	public static int findGCDIterative(int n1, int n2) {
		int gcd = 1;

		int min = Math.min(n1, n2);
		for (int i = 2; i < min; i++) {
			while (n1 % i == 0 && n2 % i == 0) {
				gcd *= i;
				n1 = n1 / i;
				n2 = n2 / i;
			}
		}

		return gcd;
	}

	public static int findGCD(int n1, int n2) {

		if(n2==0) {
			return n1;
		}else {
			 return findGCD(n2, n1%n2);
		}
	}

	public static void main(String[] args) {
		System.out.println("gcd for : " + findGCD(12, 48));
	}

}