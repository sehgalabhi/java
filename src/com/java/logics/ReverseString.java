package com.java.logics;

public class ReverseString {
	public static void main(String[] args) {
		String s1 = "Hello How are you";
		ReverseString reverseString = new ReverseString();
		String reversed = reverseString.reverse(s1);
		System.out.println(reversed);
	}

	public String reverse(String s1) {
		char[] charArray = s1.toCharArray();
		swap(s1, 0, s1.length()-1, charArray);
		
		System.out.println(charArray);
		return String.valueOf(charArray);
				
	}
	
	public void swap(String str, int startIndex, int endIndex, char[] charArray){
		if(startIndex == endIndex || startIndex > endIndex){
			return;
		}
		char start = str.charAt(startIndex);
		char end = str.charAt(endIndex);
	
		charArray[startIndex] = end;
		charArray[endIndex] = start;
		swap(str, ++startIndex, --endIndex, charArray);
		
		
				
	}
}
