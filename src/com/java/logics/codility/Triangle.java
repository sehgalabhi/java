package com.java.logics.codility;

import java.util.Arrays;

public class Triangle {
	public static void main(String[] args) {
		int A[] = { 10, 2, 5, 1, 8, 20 };
	//	int A[] =  {10,50,5,1};
		Arrays.sort(A);
		int retVal = 0;
		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] + A[i + 1] > A[i + 2] && A[i] + A[i + 2] > A[i + 1] && A[i + 2] + A[i + 1] > A[i]) {
				retVal = 1;
			}
		}
		System.out.println(retVal);

	}
}
