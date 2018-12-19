package com.ailhanli.basic_datastructures.x1;

import com.ailhanli.basic_datastructures.stack.Stack;

public class SolveBracketProblem {

	public String solve(String word) {
		Stack<String> stack = Stack.getInstance();

		char[] chars = word.toCharArray();

		int i;
		for (i = 0; i < chars.length; i++) {

			String x = chars[i] + "";

			if(!x.equals("(") && !x.equals(")")
				&& !x.equals("[") && !x.equals("]")
				&& !x.equals("{") && !x.equals("}")){
				continue;
			}
			
			if (x.equals("(") || x.equals("[") || x.equals("{")) {
				stack.push(x);
				continue;
			}

			String oldOne = stack.pop();
			if (!(oldOne.equals("(") && x.equals(")")) && !(oldOne.equals("{") && x.equals("}"))
					&& !(oldOne.equals("[") && x.equals("]"))) {
				return String.valueOf(i + 1);

			}
		}
		if (stack.empty()) {
			return "0";
		}
		return String.valueOf(i);
	}

}