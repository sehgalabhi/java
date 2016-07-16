package com.java.logics.codility;

import java.util.Arrays;

public class CodilityTest3 {
	int solution(int N) {
		int[] A = { 0, 3, 9, 7, 5, 8, 11, 1 };

		Arrays.stream(A).forEach(System.out::print);
		System.out.println();
		Arrays.sort(A);

		int retVal = -2;
		int minDiFF = 0;
		// is there any unique
		for (int i = 0; i < A.length; i++) {
			
			int diff = A[i + 1] - A[i];
			if(i==0){
				minDiFF = diff;
			}
			if (A[i + 1] == A[i]) {
				retVal = 0;
				break;
			} else if (diff > 1) {
				if(diff < minDiFF){
					minDiFF = diff;
				}
				if (diff > 100_000_000) {
					retVal = -1;
					break;
				}
				
			}
		}

		Arrays.stream(A).forEach(System.out::print);

		return retVal;
	}

	public static void main(String[] args) {
		CodilityTest3 codilityTest2 = new CodilityTest3();

		codilityTest2.solution(957);
	}
}
