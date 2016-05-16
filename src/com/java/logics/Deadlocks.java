package com.java.logics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlocks {

	public static void main(String[] args) throws InterruptedException {
		A a = new A();
		Runnable r1 = () -> {
			System.out.println(Thread.currentThread().getName());
			try {
				a.method1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Runnable r2 = () -> {
			System.out.println(Thread.currentThread().getName());
			try {
				a.method2();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread t1 = new Thread(r1);

		Thread t2 = new Thread(r2);

		t1.start();

		t2.start();
	}

}

class A {
	private Lock lock1 = new ReentrantLock();

	private Lock lock2 = new ReentrantLock();

	public void method1() throws InterruptedException {
		lock1.lock();
		Thread.sleep(1000);
		lock2.lock();
		lock1.unlock();
		lock2.unlock();

	}

	public void method2() throws InterruptedException {
		
		lock2.lock();
		Thread.sleep(1000);
		lock1.lock();
		lock1.unlock();
		lock2.unlock();
	}

}