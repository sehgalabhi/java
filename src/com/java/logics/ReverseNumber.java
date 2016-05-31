package com.java.logics;

public class ReverseNumber {

	public static void main(String[] args) {

		Integer number = new Integer(300);
		ReverseNumber number2 = new ReverseNumber();
		number2.reverse(number);
		System.out.println(number2.stringBuffer.toString());
	}

	private StringBuffer stringBuffer = new StringBuffer();

	public void reverse(int dividend) {

		int val = Integer.remainderUnsigned(dividend, 10);
		int remainderDiv = Integer.divideUnsigned(dividend, 10);
		stringBuffer.append(val);
		if (remainderDiv >= 10) {
			
			reverse(remainderDiv);
		}else {
			stringBuffer.append(remainderDiv);
		}
		
	}
}
