package com.java.designpattern.strategy;

public class QuackNo implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("No quack");
		
	}

	
}
