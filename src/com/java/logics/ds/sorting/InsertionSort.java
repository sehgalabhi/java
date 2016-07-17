package com.java.logics.ds.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] A = { 2, 5, 7, 4, 8, 1 };
		
		sort(A);
		Arrays.stream(A).forEach(System.out::print);
		System.out.println();
		A = new int[] { 14, 33, 27, 10, 35, 19, 42, 44 };
		sort(A);

		Arrays.stream(A).forEach(System.out::print);
		System.out.println();
		
		A = new int[] { -2, -1, 7, 4, 8, 10 };
		sort(A);

		Arrays.stream(A).forEach(System.out::print);
		System.out.println();
		
	}

	private static void sort(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {
			boolean swapped = false;
			if (A[i] > A[i + 1]) {
				for (int j = i + 1; j > 0; j--) {
					if (A[j] < A[j - 1]) {
						swap(A, j, j - 1);
						swapped = true;
					}
				}
				if (!swapped) {
					break;
				}

			}

			

		}
	}

	private static void swap(int[] A, int a, int b) {
		int sum = A[a] + A[b];
		A[a] = sum - A[a];
		A[b] = sum - A[a];

	}
}
