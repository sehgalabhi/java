package com.java.logics.codility;

import java.math.BigDecimal;
import java.util.Arrays;

public class PermMissingElem {
public static void main(String[] args) {
	int[] A = {3,4,1,5};
	long N = A.length;
	long sum = Arrays.stream(A).mapToLong(Long::new).sum();
	long sumN = N*(N+1)/2;
	int missingNum = (int) ((N+1) - (sum - sumN));
	System.out.println(missingNum);
	
	
}
}
