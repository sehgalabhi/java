package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterfaceUse {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));

		// Predicate interface with Inner class syntax

		Predicate<Person> pred = new Predicate<Person>() {

			@Override
			public boolean test(Person t) {
				// TODO Auto-generated method stub
				return (t.getAge() >= 65);
			}
		};

		for (Person person : people) {
			if (pred.test(person)) {
				System.out.println(person.toString());
			}
		}

		Predicate<Person> predOlder = (p) -> {
			return p.getAge() > 65;
		};

		Predicate<Person> predYounger = p -> p.getAge() < 40;

		displayName(people, predYounger);
	}

	private static void displayName(List<Person> people, Predicate<Person> predOlder) {
		people.forEach(p -> {
			if (predOlder.test(p)) {
				System.out.println(p);
			}
		});
	}
}
