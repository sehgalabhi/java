package com.java.logics.codility;

public class NumberofDiscInsertions {
	public static void main(String[] args) {
		int[] A = { 1, 5, 2, 1, 4, 0 };
		int N = A.length;
		int[][] matrix = new int[N][N];
int index =0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]+ i > N-1){
			index = N-1;
			} else{
				index = A[i]+i;
			}
			matrix[i][index] = 1;
		}

		
	}

}
