package com.java.logics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i+1);
		}
		
		System.out.println(list);
		
		Stack<Integer> stack = new Stack<>();
		for(Integer i : list){
			stack.push(i);
		}
		
		List<Integer> reversedList = new ArrayList<>();
		while (!stack.isEmpty()) {
			reversedList.add(stack.pop());
		}
		
		System.out.println(reversedList);
		
	}
	
}
