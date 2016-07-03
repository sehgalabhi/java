package com.java.logics;

public class BitwiseOp {
	public static void main(String[] args) {
		int a = 42 ^ 15;
		System.out.println(a);
		
		int b = 42 | 15;
		System.out.println(b);
		
		a = 6;
		System.out.println(~a);
		System.out.println(0x0f);
		System.out.println((~a & 0x0f));
		byte c =0b1;
		System.out.println(c);
		System.out.println(Integer.toBinaryString(-2_147_483_648));
		
		System.out.println(Integer.toBinaryString(2_147_483_647));
		System.out.println(Integer.toBinaryString(2_147_483_647 << 1));
		System.out.println(2_147_483_647 <<1);
		System.out.println(Integer.toBinaryString(-1));
		
	}
}
