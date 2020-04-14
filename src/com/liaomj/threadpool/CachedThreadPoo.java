package com.liaomj.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 执行很多短期异步的小程序或者负载较轻的服务器
public class CachedThreadPoo {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i <= 10; i++) {
			int n = i;
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			cachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + n);
				}
			});
		}
		cachedThreadPool.shutdown();
	}
}
