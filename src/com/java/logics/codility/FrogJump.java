package com.java.logics.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FrogJump {
	/*
	 * public static void main(String[] args) { int[] A = {9,3,9,3,9,7,9};
	 * 
	 * int incr = -1; int upaired = -1; for (int i = 0; i < A.length; i++) {
	 * 
	 * if(A[i] >0){ upaired=A[i]; for (int j = 0; j < A.length; j++) { if(i!= j
	 * && A[i] == A[j]&& A[j] >0){ A[i]=incr; A[j]=incr; incr--; upaired = -1;
	 * break; } } } if(upaired != -1){ break; } }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// System.out.println((int)Math.ceil(a)
		int Y = 105	, X = 5, D = 3;
		int minSteps = 0;

		BigDecimal y = new BigDecimal(Y);
		BigDecimal x = new BigDecimal(X);
		BigDecimal d = new BigDecimal(D);

		BigDecimal m = y.subtract(x).divide(d, 2, RoundingMode.HALF_EVEN);
		if(m.remainder(new BigDecimal(1)).compareTo(new BigDecimal(0)) !=0){
			minSteps = m.intValue()+1;
		} else {
			minSteps = m.intValue();
		}
		

		BigDecimal b = new BigDecimal(0.45);
		System.out.println(minSteps);

	}
}
