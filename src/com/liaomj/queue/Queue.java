package com.liaomj.queue;

public class Queue {
	private int n;
	boolean flag = false;  // 1.加锁，队列有数必须先消费，无数必须先生产
	
	public synchronized int get() {
		if(!flag) {
			try {
				wait();   // 2.线程等待，当队列无数时等待生产
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("消费："+n);
		flag = false;
		notifyAll();  // 解除线程等待
		return n;
	}
	
	public synchronized void set(int n){  // 保证此方法全部执行
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("生产："+n);
		this.n = n;
		flag = true;
		notifyAll();
	}
	
}
