package com.java.logics.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class MinAvgTwoSlice {
	public static void main(String[] args) {
		int A[] = { 4, 2, 2, 5, 1,5,8 };

		BigDecimal minAvg = new BigDecimal(0);
		int minSliceIndex = 0;
		
		int highIndex = A.length;
		int totalSum = Arrays.stream(A).sum();
		int outSum = totalSum;
		int tmpSum =0;
		for (int i = 0; i < A.length-1; i++) {
			if(i!=0){
				outSum = outSum - A[i-1];
			}
			tmpSum = outSum;
			for (int j = A.length-1; j > i; j--) {
				
				BigDecimal tmpAvg = new BigDecimal(tmpSum).divide(new BigDecimal(j+1  - i), 2, RoundingMode.HALF_EVEN);
				if(i==0 && j==A.length-1 ){
					minAvg = tmpAvg;
					
				} else{
					if(tmpAvg.compareTo(minAvg) <0){
						minAvg = tmpAvg;
						minSliceIndex = i;
					}
				}
				tmpSum= tmpSum - A[j];
			//	sliceArr[i][A.length - 1 - i] = tmpAvg.intValue();
			}

		}
System.out.println(minSliceIndex);
	}
}



/*
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
      
		BigDecimal minAvg = new BigDecimal(0);
		int minSliceIndex = 0;
		
		int highIndex = A.length;
		int totalSum = Arrays.stream(A).sum();
		int outSum = totalSum;
		int tmpSum =0;
		for (int i = 0; i < A.length-1; i++) {
			if(i!=0){
				outSum = outSum - A[i-1];
			}
			tmpSum = outSum;
			for (int j = A.length-1; j > i; j--) {
				
				BigDecimal tmpAvg = new BigDecimal(tmpSum).divide(new BigDecimal(j+1  - i), 2, RoundingMode.HALF_EVEN);
				if(i==0 && j==A.length-1 ){
					minAvg = tmpAvg;
					
				} else{
					if(tmpAvg.compareTo(minAvg) <0){
						minAvg = tmpAvg;
						minSliceIndex = i;
					}
				}
				tmpSum= tmpSum - A[j];
			//	sliceArr[i][A.length - 1 - i] = tmpAvg.intValue();
			}

		}
		return minSliceIndex;
    }
}*/