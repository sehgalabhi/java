package com.java8.lambda;

public interface PersonInterface {
	String getName();
	
	int getAge();

	default String getPersonInfo() {
		return getName() + "(" + getAge();
	}
	
	static String getPersonInf(Person p){
		return p.getName() + p.getAge();
	}
}
