package com.java.logics.codility;

import java.math.BigDecimal;

public class OddOccurencesInArray {
/*	public static void main(String[] args) {
		int[] A = {9,3,9,3,9,7,9};
		
		int incr = -1;
		int upaired = -1;
		for (int i = 0; i < A.length; i++) {

			if(A[i] >0){
				upaired=A[i];
			for (int j = 0; j < A.length; j++) {
				if(i!= j && A[i] == A[j]&& A[j] >0){
					A[i]=incr;
					A[j]=incr;
					incr--;
					upaired = -1;
					break;				
				}				
			}
			}
			if(upaired != -1){
				break;
			}
		}
		
	}*/

	public static void main(String[] args) {
	
	        
	        
		int[] A = {9,3,9,3,9,7,9};
		int missingValue = 0;
		for (int i = 0; i < A.length; i++) {
			missingValue ^= A[i];
		}
		System.out.println(missingValue);
		}
}
