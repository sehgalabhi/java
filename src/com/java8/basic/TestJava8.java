package com.java8.basic;

public class TestJava8 {

	public static void main(String[] args) {
		TestJava8Interface tester = () -> System.out.println("Java 8 is working");
		tester.test();
	}
}
