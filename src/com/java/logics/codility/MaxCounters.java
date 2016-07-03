package com.java.logics.codility;

import java.util.Arrays;

public class MaxCounters {
	public static void main(String[] args) {
		int N = 5;
		int[] counter = new int[N];
		
		int[] A = {3,4,4,6,1,4,4};
		int maxCounertVal = 0;
		for (int i = 0; i < A.length; i++) {
			if(1<= A[i] &&  A[i]<= N ){
				counter[A[i] - 1] += 1;
				if(maxCounertVal < counter[A[i] - 1]){
					maxCounertVal++;
				}
			} else if (A[i] == N+1) {
				for (int j = 0; j < counter.length; j++) {
					counter[i] = maxCounertVal;
				}
			}
		}
		
		Arrays.stream(counter).forEach(System.out::println);
		
	}
}
