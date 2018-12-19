package com.ailhanli.dynamic_arrays;

public class ArrayList<T> implements List<T> {

	private final static int DEFAULT_SIZE=8;
	
	private int capacity=0;
	
	private int size=DEFAULT_SIZE;
	
	private T[] data = (T[])new Object[DEFAULT_SIZE];
	
	@Override
	public T get(int index) {
		if(index>=capacity || index<0) {
			throw new IllegalAccessError("index is invalid");
		}
		
		return data[index];
	}

	@Override
	public void remove(int index) {
		if(index>=capacity || index<0) {
			throw new IllegalAccessError("index is invalid");
		}
		
		if(index<capacity-1) {
			for(int i=index;i<capacity;i++) {
				data[i]=data[i+1];
			}
		}	
		capacity= capacity-1;
	}

	@Override
	public void add(T value) {
		if(capacity==size) {
			int newSize = size*2;
			T[] newArray = (T[])new Object[newSize];
			for (int i = 0; i < data.length; i++) {
				newArray[i] = data[i];
			}
			data=newArray;
		}
		
		data[capacity++] = value;
	}

	@Override
	public int size() {
		return capacity;
	}

	@Override
	public void set(int index, T value) {
		if(index>=capacity || index<0) {
			throw new IllegalAccessError("index is invalid");
		}
		
		data[index] = value;
		
	}
}