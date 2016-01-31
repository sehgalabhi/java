package com.java8.lambda;

import java.util.Comparator;

public class Person {

	String name;

	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name;
	}
	
	public static int compareAges(Person p1, Person p2){
		Integer age1 = p1.getAge();
		return age1.compareTo(p2.getAge());
	}
}
