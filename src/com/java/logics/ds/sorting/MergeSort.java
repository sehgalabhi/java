package com.java.logics.ds.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
	//	int[] A = { 2, 5, 7, 4, 8, 1 };
		int[] A = {14,35,27,10,35,19,42,44};
		int[] sortedArr = sort(A);

		Arrays.stream(sortedArr).forEach(System.out::print);
		A = new int[] { -2, -5, 7, 4, -8, 1 };
		sortedArr= sort(A);

		Arrays.stream(sortedArr).forEach(System.out::print);

		A = new int[] { 2, 1, 4, 5, 7 };
		sortedArr = sort(A);

		Arrays.stream(sortedArr).forEach(System.out::print);
	}

	private static int[] sort(int[] A) {

		int[] leftArr = Arrays.copyOfRange(A, 0, A.length/2);
		int[] rightArr = Arrays.copyOfRange(A, A.length/2, A.length);
		
		if(leftArr.length> 1){
			leftArr = sort(leftArr);
		}
		
		if(rightArr.length > 1){
			rightArr = sort(rightArr);
		}
	
	
		
		int[] mergedArr = merge(leftArr, rightArr);
		return mergedArr;
		
	}

	private static int[] merge(int[] leftArr, int[] rightArr) {
		int[] mergedArr = new int[leftArr.length+ rightArr.length];
		int left =0;
		int right =0;
		int i=0;
		
		while(i < mergedArr.length){
			if(left < leftArr.length && (right == rightArr.length || leftArr[left] < rightArr[right] )){
				mergedArr[i]= leftArr[left];
				left++;
				i++;
			}else if(right < rightArr.length){
				mergedArr[i]= rightArr[right];
				right++;
				i++;
			}
		}
		
		return mergedArr;
		
	}

	private static void swap(int[] A, int a, int b) {
		int sum = A[a] + A[b];
		A[a] = sum - A[a];
		A[b] = sum - A[a];

	}
}
