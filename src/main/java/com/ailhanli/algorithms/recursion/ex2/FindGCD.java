package com.ailhanli.algorithms.recursion.ex2;

public class FindGCD {

	  public static int gcd(int p, int q) {
	        if (q == 0) return p;
	        else return gcd(q, p % q);
	    }

	    // non-recursive implementation
	    public static int gcd2(int p, int q) {
	        while (q != 0) {
	            int temp = q;
	            q = p % q;
	            p = temp;
	        }
	        return p;
	    }


	public static void main(String[] args) {
		System.out.println("gcd for : " + gcd2(12, 48));
	}

}