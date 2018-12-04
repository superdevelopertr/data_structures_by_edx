package com.ailhanli.algorithms.recursion.ex1;

import java.io.File;

public class ScanDirectory {

	public static void main(String[] args) {
		Integer count = 0;
		
		System.out.println(scan(new File("C:\\Users\\abdullah.ilhanli\\Documents\\E-Book\\"),"pptx"));
	}
	
	
	public static int scan(File file, String format) {
		if(file.isFile()) {
			return file.getName().endsWith(format)?1:0;
		}else {
			int count = 0;
			
			for(File f:file.listFiles()) {
				count +=  scan(f,format);
			}
			return count;
		}
	}
}