package com.java.logics.codility;

public class BinrayGap {

	public static void main(String[] args) {
		int i = 16;
		// 1010
		do{
			int bit = (i & 1);
			System.out.println(bit);
			i >>= 1;
	//		System.out.println(i);
		} while(i>0);
	
		
	}
	
}
