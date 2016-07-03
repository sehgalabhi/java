package com.java.logics.codility;

public class FrogRiverOne {
	public static void main(String[] args) {
		int[] A = {1,3,1,4,2,3,5,4};
		int N= 5;
		int[] tmp = new int[N];
		int minTime = 0;
		int sumElem = 0;
		long expectedSum = (N*(N+1)/2);
		for (int i = 0; i < A.length; i++) {
			if(tmp[A[i]-1] !=0){
				continue;
			}
			tmp[A[i]-1] = A[i];
			sumElem += A[i];
			if(sumElem == expectedSum){
				minTime = i;
				break;
			}
		}
		System.out.println(minTime);
		
	}
}
