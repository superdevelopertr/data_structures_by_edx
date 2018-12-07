package com.ailhanli.tree.btree;

public class BuildBT {

	public static void addAllNodes(BT<Integer> b, Integer... numbers) {
		for (Integer n : numbers) {
			addNode(b, n);
		}
	}

	public static void addNode(BT<Integer> b, Integer number) {
		if (b == null) {
			new BT<>(number);
			return;
		}

		if (b.left == null && b.value >= number) {
			b.left = new BT<>(number);
			return;
		}

		if (b.right == null && b.value < number) {
			b.right = new BT<>(number);
			return;
		}

		if (b.value >= number) {
			addNode(b.left, number);
		} else {
			addNode(b.right, number);
		}
	}

}