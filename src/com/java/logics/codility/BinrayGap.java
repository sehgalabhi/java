package com.java.logics.codility;

public class BinrayGap {

	public static void main(String[] args) {
		int i = 15;

		do{
			int bit = (i & 1);
			System.out.println(bit);
			i >>= 1;
	//		System.out.println(i);
		} while(i>0);
	
		
	}
	
}
