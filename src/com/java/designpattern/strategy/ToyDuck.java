package com.java.designpattern.strategy;

public class ToyDuck extends Duck {

	public ToyDuck() {
		setFlyBehavior(new FlyNoWay());
		super.setQuackBehavior(new QuackNo());
	}

	@Override
	public void display() {
		System.out.println("Toy Duck");

	}

}
