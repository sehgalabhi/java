package com.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java8.basic.Apple;

public class TestJava8BookMethodRef {
	public static void main(String[] args) {
		TestJava8BookMethodRef bookMethodRef = new TestJava8BookMethodRef();
		bookMethodRef.test();
	}

	private void test() {
		List<String> str = Arrays.asList("a", "b", "A", "B");
		System.out.println(str);
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(str);

		str.sort(String::compareToIgnoreCase);
		System.out.println(str);

		//static references
		Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);

		Function<String, Integer> stringToInteger1 = Integer::parseInt;

		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		
		BiPredicate<List<String>, String> contains1 = List::contains;
		
		//constructor references
		Supplier<Apple> supplier = () -> new Apple();
		System.out.println(supplier.get());
		Supplier<Apple> supplier1 = Apple::new;
		System.out.println(supplier1.get());
		
		
		Function<Integer, Apple> c2 = Apple::new;

		System.out.println(c2.apply(120));
		
		BiFunction<String, Integer, Apple> b1 = Apple::new;
		System.out.println(b1.apply("green", 20));
	}
}
