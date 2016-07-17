package com.java.logics.ds.sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] A = { 2, 5, 7, 4, 8, 1 };
		
		sort(A);

		Arrays.stream(A).forEach(System.out::print);
		 A = new int[]{ -2, -5, 7, 4, -8, 1 };
		 sort(A);

			Arrays.stream(A).forEach(System.out::print);
			
			 A = new int[]{ 2,1,4,5,7,8 };
			 sort(A);

				Arrays.stream(A).forEach(System.out::print);
	}

	private static void sort(int[] A) {
		
		for (int i = 0; i < A.length - 1; i++) {
			boolean swapped = false;
			for (int j = 1; j < A.length - i; j++) {
				if (A[j] < A[j - 1]) {
					swap(A, j, j - 1);
					swapped=  true;
				}
			}
			if(!swapped){
				System.out.println("Already swapped on index "+ i);
				break;
			}

		}
	}

	private static void swap(int[] A, int a, int b) {
		int sum = A[a] + A[b];
		A[a] = sum - A[a];
		A[b] = sum - A[a];

	}
}
