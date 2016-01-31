package com.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UseComparator {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");

		// simple case sensitive
		Collections.sort(strings);

		System.out.println("Simple sort");
		for (String string : strings) {
			System.out.println(string);
		}

		// case in sensitive sort
		Collections.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareToIgnoreCase(o2);
			}

		});
		
		for (String string : strings) {
			System.out.println(string);
		}

		Comparator<String> comparator = (o1,o2) -> {
			return o1.compareToIgnoreCase(o2);
		};
		Collections.sort(strings, comparator);
		for (String string : strings) {
			System.out.println(string);
		}

		
	}
}
