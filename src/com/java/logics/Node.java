package com.java.logics;

public class Node<T extends Number> {

	public T value;

	public Node<T> nextRef;

	public void print() {

		System.out.print(" " + value);

	}
	
	public String toString(){
		return value.toString() + " Next "+ ((nextRef != null  ? nextRef.value : "null"));
	}

}
