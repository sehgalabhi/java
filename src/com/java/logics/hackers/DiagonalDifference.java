package com.java.logics.hackers;

import java.util.Scanner;

public class DiagonalDifference {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int[][] matrix = new int[N][N];

		scanner.nextLine();

		int sumDiag1 = 0;
		int sumDiag2 = 0;
		for (int i = 0; i < N; i++) {
			String tmp[] = scanner.nextLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(tmp[j]);

			
					if (i == j) {
						sumDiag1 += matrix[i][j];
						if (N % 2 != 0 && i == N / 2) {
							sumDiag2 += matrix[i][j];
						}

					} else {
						if(j == N-1 -i){
							sumDiag2 += matrix[i][j];
						}
					}
				

			}
		}
		System.out.println(Math.abs((sumDiag1 - sumDiag2)));

	}
}
