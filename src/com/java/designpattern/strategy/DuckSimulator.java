package com.java.designpattern.strategy;

public class DuckSimulator {

	public static void main(String[] args) {
	 Duck mallardDuck = new MallardDuck();
	 mallardDuck.display();
	 mallardDuck.perform();
	 mallardDuck.performFly();
	 mallardDuck.performQuack();
	 
	 Duck toyDuck = new ToyDuck();
	 toyDuck.display();
	 toyDuck.perform();
	 toyDuck.performFly();
	 toyDuck.performQuack();
	}

}
