package com.java.logics.codility;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TapEquilibrium {
	public static void main(String[] args) {
 //int[] A= {3,1,2,4,3};
	//	int[] A = { -1000, -800, 800, 700 };
		int[] A = {-1000, 1000};
		long minDiff = 0;
		long sumForward = 0;
		long sum = Arrays.stream(A).sum();

		for (int i = 0; i < A.length-1; i++) {
			sumForward += A[i];
			long symBackward = sum - sumForward;
			long tmpDiff = Math.abs(symBackward - sumForward);

			if (i == 0) {
				minDiff = tmpDiff;
			} else if (tmpDiff < minDiff) {
				minDiff = tmpDiff;
			}

		}
		System.out.println(minDiff);

	}
}
