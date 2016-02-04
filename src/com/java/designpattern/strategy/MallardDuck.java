package com.java.designpattern.strategy;

public class MallardDuck extends Duck {
	public MallardDuck() {
		setFlyBehavior(new FlyAround());
		super.setQuackBehavior(new QuackDo());
	}

	@Override
	public void display() {
		System.out.println("Mallard duck");

	}

}
