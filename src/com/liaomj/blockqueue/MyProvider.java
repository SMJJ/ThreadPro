package com.liaomj.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

import com.liaomj.util.CurrentTime;

public class MyProvider implements Runnable {
	private volatile LinkedBlockingQueue queue;
	private static boolean flag = false;
	
	public MyProvider(LinkedBlockingQueue queue) {
		this.queue = queue;
	}
	
	public void toStop() {
		System.out.println("stop..");
		this.flag = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!flag) {
			try {
				queue.put(CurrentTime.currentTime()+"mytime");
				queue.put("mytime");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+" sleep 500ms");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
