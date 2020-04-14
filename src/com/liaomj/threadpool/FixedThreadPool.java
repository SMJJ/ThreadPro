package com.liaomj.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 执行长期的任务，性能好很多
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i <= 10; i++) {
			int n = i;
			
			fixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + n);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		fixedThreadPool.shutdown();
	}
}
