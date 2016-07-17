package com.java.logics.ds.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] A = { 2, 5, 7, 4, 8, 1 };

		sort(A);

		Arrays.stream(A).forEach(System.out::print);
		A = new int[] { -2, -5, 7, 4, -8, 1 };
		sort(A);

		Arrays.stream(A).forEach(System.out::print);
	}

	private static void sort(int[] A) {
		
		for (int i = 0; i < A.length - 1; i++) {
		
			int minIndex=i;
			for (int j = i; j < A.length ; j++) {
				
				if(A[j] < A[minIndex]){
					minIndex= j;
				}
					
			}
			
			swap(A, i, minIndex);

		}
	}

	private static void swap(int[] A, int a, int b) {
		int sum = A[a] + A[b];
		A[a] = sum - A[a];
		A[b] = sum - A[a];

	}
}
