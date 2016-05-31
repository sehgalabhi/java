package com.java8.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TestJava8 {

	public static void main(String[] args) {
		TestJava8Interface tester = () -> System.out.println("Java 8 is working");
		tester.test();

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

		Collections.sort(names, (String o1, String o2) -> {
			return o1.compareTo(o2);
		});

		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);

		Converter<String, Integer> converter2 = Integer::valueOf;
	}

	
}
