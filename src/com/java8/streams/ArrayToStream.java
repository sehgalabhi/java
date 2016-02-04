package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.java8.lambda.Person;

public class ArrayToStream {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));
		Person[] person = new Person[3];
		person = people.toArray(person);

		//Stream<Person> stream = Stream.of(person);
		Stream<Person> stream = Arrays.stream(person);
		stream.forEach(p -> System.out.println(p.getName()));
	}

}
