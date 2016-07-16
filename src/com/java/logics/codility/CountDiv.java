package com.java.logics.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CountDiv {
	public static void main(String[] args) {
		int res = test(3,11,2);
		System.out.println(res);
		res = test(3, 12, 2);
		
		System.out.println(res);
		res = test(1, 15, 5);
		System.out.println(res);
	}

	private static int test(int A, int B, int K) {
		
		BigDecimal lowerBound = new BigDecimal(A).divide(new BigDecimal(K), 0,  RoundingMode.CEILING);
		BigDecimal upperBound = new BigDecimal(B).divide(new BigDecimal(K), 0, RoundingMode.FLOOR);
		
		return (upperBound.intValue() - lowerBound.intValue()) + 1;
	}
}
