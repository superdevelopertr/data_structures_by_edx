package com.ailhanli.stack.ex1;

import com.ailhanli.stack.Stack;
import com.ailhanli.stack.StackArrayImpl;

public class ParantesisSolution {

	public boolean isBalanced(String word) {
		Stack<String> stack = new StackArrayImpl<>();

		for (int i = 0; i < word.length(); i++) {
			String newSymbol = "" + word.charAt(i);

			if (newSymbol.equals("(") || newSymbol.equals("[")) {
				stack.push("" + newSymbol);
			} else {
				String firstSymbol = stack.pop();

				if ((!firstSymbol.equals("(") && newSymbol.equalsIgnoreCase(")"))
						|| (!firstSymbol.equals("[") && newSymbol.equalsIgnoreCase("]"))) {
					return false;
				}
			}
		}

		return stack.empty();
	}
}