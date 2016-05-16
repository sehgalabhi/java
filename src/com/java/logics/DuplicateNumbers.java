package com.java.logics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DuplicateNumbers {
	
	public int findDuplicateNumber(List<Integer> list){
		int number = -1;
		
		int total = getSum(list);
		
		int highestNumber = list.size() -1;
		
		int duplicate = total - ( highestNumber* (highestNumber+1)/2);
		System.out.println(duplicate);
		return number;
	}

	private int getSum(List<Integer> list) {
		int sum = 0;
		
		
		for (Integer integer : list) {
			sum += integer;
		}
		return sum;
	}

	public static void main(String[] args) {
		DuplicateNumbers duplicateNumbers = new DuplicateNumbers();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 30; i++) {
			list.add(i);
		}
		
		list.add(22);
		duplicateNumbers.findDuplicateNumber(list);
	}
	
	

}
