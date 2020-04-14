package com.liaomj.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 一个任务一个任务执行的场景
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		for (int i = 0; i <= 10; i++) {
            final int ii = i;
            pool.execute(() -> System.out.println(Thread.currentThread().getName() + "=>" + ii));
        }
		pool.shutdown();
	}
}
