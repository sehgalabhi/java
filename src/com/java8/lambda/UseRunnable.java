package com.java8.lambda;

public class UseRunnable {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("hello inner class local to method");

			}
		};

		new Thread(r).start();

		// new Anonymous class

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello  anaonymous class");

			}
		}).start();

		// With Lambda single line

		Runnable rLambda = () -> System.out.println("hello lambda");
		new Thread(rLambda).start();

		// with lambda multiple lines

		Runnable rLambda1 = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(2);
		};
	}
}
