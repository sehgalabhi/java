package com.java.logics.codility;

public class TapEquilibrium {
	public static void main(String[] args) {
		//int[] A= {3,1,2,4,3};
		int[] A= {-1000,-800,800,700};
		int SumForward =0;
		int SumBackward =0;
		int minDiff = 0;
		
		for (int i = 0; i < A.length; i++) {
			SumBackward=0;
			SumForward=0;
			for (int j = i; j >=0; j--) {
				SumForward += A[j];
			}
			
			for (int j = i+1; j < A.length; j++) {
				SumBackward += A[j];
			}
			int tmpDiff = Math.abs(SumBackward - SumForward) ;
			if (i==0) {
				minDiff = tmpDiff;
			} else 	if(tmpDiff < minDiff){
				minDiff =tmpDiff;
			}
			
		}
		System.out.println(minDiff);
		
		
		
	}
}
