package com.java.logics.codility;

public class PermMissingElem {
public static void main(String[] args) {
	int[] A = {3,4,1,5};
	
	int sum = 0;
	for (int i = 0; i < A.length; i++) {
		sum += A[i];
	}
	int sumN = 4*5/2;
	
	int missingNum = (4+1) - (sum - sumN);
	System.out.println(missingNum);
	
	
}
}
