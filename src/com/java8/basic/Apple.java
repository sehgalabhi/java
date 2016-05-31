package com.java8.basic;

import java.util.ArrayList;
import java.util.List;

public class Apple {

	public int weight;

	public String color;

	public Apple(String color, int weight) {
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static List<Apple> getApplesList() {
		List<Apple> apples = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			apples.add(new Apple("green", i * 20));
		}
		for (int i = 0; i < 10; i++) {
			apples.add(new Apple("yellow", i * 20));
		}

		for (int i = 0; i < 10; i++) {
			apples.add(new Apple("blue", i * 20));
		}

		for (int i = 0; i < 10; i++) {
			apples.add(new Apple("red", i * 20));
		}

		return apples;
	}

	public String toString() {
		return "Color->" + this.color + " Weiht->" + weight;
	}

}
