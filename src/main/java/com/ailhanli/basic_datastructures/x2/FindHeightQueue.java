package com.ailhanli.basic_datastructures.x2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.ailhanli.basic_datastructures.queue.Queue;
import com.ailhanli.basic_datastructures.queue.QueueArrayImpl;

public class FindHeightQueue {

	public static int findHeight(int[] numbers) throws Exception {

		Queue<Integer> queue = new QueueArrayImpl<>();

		int[] value = findIndex2(numbers, -1);
		if (value.length > 1) {
			return -1;
		}

		queue.enqueue(value[0]);

		int height = 0;
		while (!queue.empty()) {
			int temp = queue.dequeue();
			int[] newValue = findIndex(numbers, temp);
			if (newValue != null && newValue.length > 0) {
				Arrays.stream(newValue).forEach(value1 -> {
					try {
						queue.enqueue(value1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				height++;
			}
		}
		return height;
	}

	public static int[] findIndex(int[] numbers, int key) {

		List<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == key) {
				indexes.add(i);
			}
		}
		return indexes.stream().mapToInt(Integer::valueOf).toArray();
	}

	public static int[] findIndex2(int[] numbers, int key) {
		return IntStream.range(0, numbers.length).filter(i -> numbers[i] == key).toArray();
	}
}