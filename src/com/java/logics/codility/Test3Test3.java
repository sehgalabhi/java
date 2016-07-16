package com.java.logics.codility;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class Test3Test3 {

	CodilityTest3 test3 = new CodilityTest3();

	@Test
	public void test1() {
		int n = test3.solution(1);
		
		Assert.assertEquals(1, n);;
	}

	@Test
	public void test2() {
		int[] A = new int[20000];
		for (int i = 0; i < A.length; i++) {
			A[i] = i;
		}
		int n = test3.solution(1);
		Assert.assertEquals(-1, n);
	}

}
