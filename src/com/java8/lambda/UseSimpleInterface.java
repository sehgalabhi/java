package com.java8.lambda;

import com.java8.lambda.interfaces.SimpleInterface;

public class UseSimpleInterface {
	public static void main(String[] args) {
		SimpleInterface obj = () -> System.out.println("say something");
		obj.doSomething();
	}
}
