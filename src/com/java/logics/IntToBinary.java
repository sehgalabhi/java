package com.java.logics;

public class IntToBinary {
	public static void main(String[] args) {
		int b= 6;
		System.out.println("Binary eqivalent of 100 = " + Integer.toString(100, 2));
        System.out.println("Octal eqivalent of 100 = " + Integer.toString(100, 8));
        System.out.println("Decimal eqivalent of 100 = " + Integer.toString(100, 10));
        System.out.println("Hexadecimal eqivalent of 100 = " + Integer.toString(100, 16));
		System.out.println(Integer.toBinaryString(b));
		
	}
}
