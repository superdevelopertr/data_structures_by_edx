package com.ailhanli.dynamic_arrays;

public interface List<T> {
	
	T get(int index);
	
	void set(int index, T value);
	
	void remove(int index);
	
	void add(T value);
	
	int size();
}