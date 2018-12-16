package com.ailhanli.basic_datastructures.x2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HeightTask implements Callable<Integer>{

	private String input;
	
	public HeightTask(String input) {
		super();
		this.input = input;
	}

	@Override
	public Integer call() throws Exception {
		List<Integer> nodes = Stream.of(input).flatMap(i -> Arrays.stream(i.split(" "))).map(Integer::valueOf)
				.collect(Collectors.toList());
		
		List<Integer> indexOfRoot = findValuesOfIndex(nodes, -1);
		if (indexOfRoot.size() != 1) {
			return 0;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(indexOfRoot.get(0));
		
		return height(nodes, queue );		
	}
	
	public int height(List<Integer> nodes, Queue<Integer> queue) {

		if (queue.isEmpty()) {
			return 1;
		}

		Integer value = queue.poll();

		List<Integer>childs = findValuesOfIndex(nodes, value);
		for (Integer child : childs) {
			queue.offer(child);
		}
		if(childs.size()==0){
			return height(nodes, queue);
		}else{
			return 1+height(nodes, queue);
		}

		
	}

	public List<Integer> findValuesOfIndex(List<Integer> nodes, int value) {
		// return IntStream
		// .range(0, nodes.size())
		// .filter(i->nodes.get(i)==value)
		// .mapToObj(Integer::valueOf)
		// .collect(Collectors.toList());

		List<Integer> values = new ArrayList<>();
		int index = 0;
		for (Integer node : nodes) {
			if (value == node) {
				values.add(index);
			}
			index++;
		}
		return values;
	}

	
}

public class FindHeightMultiThreaded  {

	public int height(String input) throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(8);
		Integer result = es.submit(new HeightTask(input)).get();
		return result;
	}
}
