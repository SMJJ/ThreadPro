package com.liaomj.queue;

public class Consumer implements Runnable{
	Queue queue;
	public Consumer(Queue queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			queue.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
