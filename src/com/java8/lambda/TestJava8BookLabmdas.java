package com.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.java8.basic.Apple;

import static java.util.stream.Collectors.*;
public class TestJava8BookLabmdas {

	public static void main(String[] args) {
		TestJava8BookLabmdas testJava8 = new TestJava8BookLabmdas();
		List<Apple> inventory = Apple.getApplesList();

		// Predicates

		List<Apple> onlyGreen = testJava8.filterApples(inventory, a -> a.color == "green");
		System.out.println(onlyGreen);

		List<Apple> onlyRed = testJava8.filterApples(inventory, a -> a.color == "red");
		System.out.println(onlyRed);

		List<Apple> below100 = testJava8.filterApples(inventory, a -> a.weight < 100);
		System.out.println(below100);

		// Stream
		List<Apple> onlyGreenMRReverseSorted = inventory.stream().filter(a -> a.color == "green")
				.sorted((a1, a2) -> a2.getWeight() - a1.getWeight()).collect(toList());
		System.out.println(onlyGreenMRReverseSorted);

		// Comparator using comparing
		onlyGreenMRReverseSorted.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(onlyGreenMRReverseSorted);
		
		inventory.sort(Comparator.comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight).reversed());
System.out.println("Chained Comparison" + inventory);
		
		// Stream grouping by
		Map<String, List<Apple>> colorListMap = inventory.stream().collect(groupingBy(Apple::getColor));
		System.out.println(colorListMap);

		// inventory.stream().filter(a -> a.getWeight() <
		// 100).collect(groupingBy(Apple::getColor))

		//Consumer
		testJava8.consumeApples(onlyGreen, a -> System.out.println("Consuming "+ a.getWeight()));
		
		// function
		List<Integer> weightList = testJava8.functionApples(onlyGreen, a -> a.getWeight());
		System.out.println(weightList);
		
		
		// Composing predicates
		Predicate<Apple> greenApple = (a -> a.getColor()=="green");
		Predicate<Apple> notGreenApple = greenApple.negate();
		Predicate<Apple> greenAndHevyApple = greenApple.and(a-> a.getWeight() > 150);
		
		//composing functions
		Function<Integer, Integer> f = x -> x+1;
		Function<Integer, Integer> g = x -> x*2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1);
		System.out.println(result);
		Function<Integer, Integer> i = f.compose(g);
		int result2 = i.apply(1);
		System.out.println(result2);
		
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

	public <T> void  consumeApples(List<T> inventory, Consumer<T> p) {

		for (T a : inventory) {
			p.accept(a);

		}

	}
	
	public <T,R> List<R> functionApples(List<T> inventory, Function<T, R> f){
		List<R> result = new ArrayList<>();
		for (T a : inventory) {
			result.add(f.apply(a));

		}
		return result;
	}

}
