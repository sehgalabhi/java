package com.java.logics.codility;

import java.util.Stack;

import javax.print.DocFlavor.STRING;

public class Brackets {
	public static void main(String[] args) {
	//	String S = "{[()()]}";
		String S= "([)()]";
		int retVal = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			char b = S.charAt(i);
			if (!stack.isEmpty() && isNegative(stack.peek(), b)) {
				stack.pop();
			} else {
				stack.add(S.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			retVal = 1;
		}
	//	return retVal;

	}

	private static boolean isNegative(char a, char b) {
		if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
			return true;
		}
		return false;
	}
}
