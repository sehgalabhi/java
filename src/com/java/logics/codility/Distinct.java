package com.java.logics.codility;

import java.util.Arrays;

public class Distinct {
	public static void main(String[] args) {
		int[] A = {2,1,1,2,3,1};
		
		Arrays.sort(A);
		int distCount = 0;
		for (int i = 0; i < A.length -1; i++) {
			if(A[i+1] != A[i] || i==0){
				distCount++;
			}
		}
		
		A= new int[]{-3, 1, 2, -2, 5, 6}; 
		Arrays.sort(A);
		long maxSum =1; 
		int N = A.length;
		int lowest = A[0];
		int highest = A[A.length-1];
		if(highest< 0 || lowest > 0){
			maxSum = A[N-1]*A[N-2]*A[N-3];
		} else{
			if(lowest <0 && A[1] <0&& highest>0){
				int sum1 =  Math.abs(lowest)+ Math.abs(A[1])+highest;
				int sum2 = highest+Math.abs(A[N-2]) + Math.abs(N-3);
				if(highest+Math.abs(A[N-2]) + Math.abs(N-3) <( Math.abs(lowest)+ Math.abs(A[1])+highest)){
					maxSum = lowest*highest*A[1];
				} else{
					maxSum =  A[N-1]*A[N-2]*A[N-3];
				}
			
			} else{
				maxSum =  A[N-1]*A[N-2]*A[N-3];
			}
		}
		
		
		
		
		System.out.println(maxSum);
	}
}
