package com.java.logics.codility;

import java.util.Arrays;

public class CyclicRotation {
	public static void main(String[] args) {
		int[] orig = { 3, 6, 2 };
/*
		int[] computed = Arrays.copyOfRange(orig, 1, 3);

		for (int j = orig.length - 1; j >= 2; j--) {
			orig[j] = orig[j - 2];
		}
		System.arraycopy(computed, 0, orig, 0, computed.length);
		*/
		Solution solution = new Solution();
		int[] res1 = solution.solution(orig, 1);

	}
}

class Solution {
	public int[] solution(int[] A, int K) {
		int[] computed = Arrays.copyOfRange(A, A.length-K, A.length);
		for (int j = A.length - 1; j >= K; j--) {
			A[j] = A[j - K];
		}
		System.arraycopy(computed, 0, A, 0, computed.length);
		return A;

	}
}