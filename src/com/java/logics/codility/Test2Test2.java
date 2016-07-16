package com.java.logics.codility;

import org.junit.Test;

import junit.framework.Assert;

public class Test2Test2 {

	CodilityTest2 test2 = new CodilityTest2();

	@Test
	public void test1() {
		int n = test2.solution(1);
		
		Assert.assertEquals(1, n);;
	}

	@Test
	public void test2() {
		int n = test2.solution(1);
		Assert.assertEquals(-1, n);
	}

}
