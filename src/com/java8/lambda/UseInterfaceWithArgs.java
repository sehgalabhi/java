package com.java8.lambda;

import com.java8.lambda.interfaces.InterfaceWithArgs;

public class UseInterfaceWithArgs {
	public static void main(String[] args) {
		InterfaceWithArgs obj = (v1, v2) -> {
			int result = v1 * v2;
			System.out.println("Result is " + result);
		};
		obj.calculate(10, 5);
	}
}
