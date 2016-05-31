package com.java8.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestJava8Book {

	public static void main(String[] args) {
		TestJava8Book testJava8 = new TestJava8Book();
		List<Apple> inventory = Apple.getApplesList();

		List<Apple> onlyGreen = testJava8.filterApples(inventory, a -> a.color == "green");
		System.out.println(onlyGreen);

		List<Apple> onlyRed = testJava8.filterApples(inventory, a -> a.color == "red");
		System.out.println(onlyRed);

		List<Apple> below100 = testJava8.filterApples(inventory, a -> a.weight < 100);
		System.out.println(below100);

		List<Apple> onlyGreenMRReverseSorted = inventory.stream().filter(a -> a.color == "green")
				.sorted((a1, a2) -> a2.getWeight() - a1.getWeight()).collect(toList());
		System.out.println(onlyGreenMRReverseSorted);
		
		onlyGreenMRReverseSorted.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(onlyGreenMRReverseSorted);
		
		Map<String, List<Apple>> colorListMap = inventory.stream().collect(groupingBy(Apple::getColor));
		System.out.println(colorListMap);
		
		//inventory.stream().filter(a -> a.getWeight() < 100).collect(groupingBy(Apple::getColor))

	}

	public void test() {

	}

	public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> results = new ArrayList<>();
		for (Apple a : inventory) {
			if (p.test(a)) {
				results.add(a);
			}
		}
		return results;

	}

}
