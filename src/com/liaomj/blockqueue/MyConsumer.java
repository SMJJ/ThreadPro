package com.liaomj.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class MyConsumer implements Runnable{
	
	private volatile LinkedBlockingQueue queue;
	private static boolean stopFlag = false;
	
	public MyConsumer(LinkedBlockingQueue queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("consumer:"+Thread.currentThread().getName()+" running");
		int count = 0;
		while(!stopFlag) {
			Object take= queue.poll();
			if(take != null) {
				count = 0;
				System.out.println("consumer:"+take);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				count ++;
	            try {
					Thread.sleep(500);
					System.out.println("consumer waiting");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(count >= 20) {
            	System.out.println(Thread.currentThread().getName()+"consumer stop");
            	stopFlag=true;
            }
		}
	}
}
