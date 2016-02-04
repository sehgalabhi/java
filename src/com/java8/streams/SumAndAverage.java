package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.java8.lambda.Person;

public class SumAndAverage {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));

		int sum = people.stream().mapToInt(p -> p.getAge()).sum();
		System.out.println(sum);
		
		OptionalDouble avg = people.stream().mapToInt(p -> p.getAge()).average();
		if (avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		} else {
			System.out.println("Average not calculated");
		}
		
		
	}
	
}
