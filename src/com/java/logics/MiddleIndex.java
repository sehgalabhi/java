package com.java.logics;

import oracle.net.aso.a;

public class MiddleIndex {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 4, 5, 4, 1 };

		MiddleIndex middleIndex = new MiddleIndex();

		int index = getMiddleIndex(arr);
		System.out.println(index);
	}

	private static int getMiddleIndex(int[] arr) {
		int startIndex = 0;
		int endIndex = arr.length - 1;
		int sumLeft = 0;
		int sumRight = 0;

		while (true) {
			if (sumLeft > sumRight) {
				sumRight += arr[endIndex--];
			} else {
				sumLeft += arr[startIndex++];
			}

			if (startIndex > endIndex) {
				if (sumLeft == sumRight) {
					return startIndex;

				}

				break;
			}

		}

		return -1;
	}

}
