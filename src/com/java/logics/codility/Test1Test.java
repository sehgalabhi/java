package com.java.logics.codility;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class Test1Test {

	CodilityTest1 test1 = new CodilityTest1();

	@Test
	public void test1() {
		int n = test1.solution(1);
		
		Assert.assertEquals(1, n);;
	}

	@Test
	public void test2() {
		int n = test1.solution(1);
		Assert.assertEquals(-1, n);
	}

}
