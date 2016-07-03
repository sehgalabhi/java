package com.java.logics;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] arr = new int[size];
		scanner.nextLine();
		String values = scanner.nextLine();

		String[] val = values.split(" ");
		long sum = Arrays.stream(val).mapToLong(Long::parseLong).sum();
		System.out.println(sum);
	}
}
