package com.java.logics.codility;

public class PassingCars {
	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 1, 1,0,1,1 };
		int N = A.length;
		
		int sumPrev = 0;
		int sumTotal = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				sumTotal = (N - (i + 1)) + (sumTotal - sumPrev++);		
				if (sumTotal > 1_000_000_000) {
					
					sumTotal = -1;
					break;
				}
			}
		}
		System.out.println(Integer.MAX_VALUE > 1_000_000_000);
		System.out.println(1_000_000_000);
		System.out.println(sumTotal);
	}
}
