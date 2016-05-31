package com.java8.basic;

public interface DefaultInterface {

	public void add(int a );
	
	default int getSum(){
		return 2;
	}
}
