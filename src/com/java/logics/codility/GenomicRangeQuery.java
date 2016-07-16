package com.java.logics.codility;

import java.util.Arrays;

public class GenomicRangeQuery {
	public static void main(String[] args) {
		test("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 });

	}

	private enum FACTOR {
		A(1), C(2), G(3), T(4);

		private int val;

		private FACTOR(int val) {
			this.val = val;
		}

		private int getFactor() {
			return this.val;
		}
		

	}

	private static void test(String S, int[] P, int[] Q) {
		int M = P.length;
		int res[] = new int[M];
		for (int i = 0; i < M; i++) {
			int loBound = P[i];
			int hiBound = Q[i];
			
			char[] sub = S.substring(loBound, hiBound+1).toCharArray();
			int minFac =0;
			for (int j = 0; j < sub.length; j++) {
				int tmp= FACTOR.valueOf(String.valueOf(sub[j])).getFactor();
				if(j==0 || tmp < minFac){
					minFac = tmp;
				}
			}
			res[i] = minFac;
		
		}
		Arrays.stream(res).forEach(System.out::print);
	}
}
