package com.java.logics.codility;

public class MissingInteger {
	public static void main(String[] args) {
	//	int[] A = { 1, 3, 6, 4, 1, 2 };
		int[] A = { 1};
		int N = A.length;

		boolean[] tmp = new boolean[N];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= N) {
				tmp[A[i] -1]= true;
						
			}

		}
		int minMissing = 0;
		for (int i = 0; i < tmp.length; i++) {
			if(!tmp[i]){
				minMissing = i+1;
				break;
			}
		}
		System.out.println(minMissing);
	}
}
