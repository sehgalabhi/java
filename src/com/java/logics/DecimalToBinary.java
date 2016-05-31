package com.java.logics;

import java.util.BitSet;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		int number = 12;
		
		
		while(number >=1){			
			int digit = number %2;
			System.out.println(digit);
			number = number/2;
		}
			
		
	}
}
