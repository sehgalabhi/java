package com.java.thread;

public class CokeProduceConsume {
	public int count = 0;
	public int max = 10;

	public static void main(String[] args) {
		CokeProduceConsume cokeProduceConsume = new CokeProduceConsume();
		Producer produ = new Producer(cokeProduceConsume);
		Consumer consum = new Consumer(cokeProduceConsume);

		Thread producer = new Thread(produ);
		Thread consumer = new Thread(consum);

		producer.start();
		consumer.start();
	}

	public void produce() {
		if (count < max) {
			count++;
			System.out.println("Added , now Count" + count);
		}

	}

	public void consume() {
		if (count > 0) {
			count--;
			System.out.println("Removed , now Count" + count);
		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

class Producer implements Runnable {
	CokeProduceConsume cokeProduceConsume;

	public Producer(CokeProduceConsume cokeProduceConsume) {
		this.cokeProduceConsume = cokeProduceConsume;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (cokeProduceConsume) {
				while (cokeProduceConsume.getCount() != 10) {
					cokeProduceConsume.produce();

				}
				try {
					cokeProduceConsume.notify();
					System.out.println("Going waiting");
					cokeProduceConsume.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}

class Consumer implements Runnable {
	CokeProduceConsume cokeProduceConsume;

	public Consumer(CokeProduceConsume cokeProduceConsume) {
		this.cokeProduceConsume = cokeProduceConsume;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (cokeProduceConsume) {
				while (cokeProduceConsume.getCount() != 0) {
					cokeProduceConsume.consume();
					
				}
				try {
					cokeProduceConsume.notify();
					System.out.println("Going waiting");
					cokeProduceConsume.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}

		}

	}

}