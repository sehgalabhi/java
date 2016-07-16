package com.java.logics.codility;

public class PermCheck {
public static void main(String[] args) {
	int[] A = {2,2,2};
	int N=A.length;
	
	long sumElem = 0;
	int retVal = 1;
	int[] tmp = new int[N];
	for (int i = 0; i < A.length; i++) {
		if(A[i]>N || tmp[A[i]-1] !=0){
			retVal = 0;
			break;
		}

		tmp[A[i]-1] = A[i];
	}
	
	System.out.println(retVal);
}
}
