package com.liaomj.threadpool;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// 周期性执行任务的场景
public class ScheduledThreadPool {
	public static String currentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date()).toString();
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		Runnable r1 = ()-> System.out.println(currentTime() + ",线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
		scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);
		Runnable r2 = () -> System.out.println(currentTime() + ",线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
		scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);
		Runnable r3 = () -> System.out.println(currentTime() + ",线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
		for (int i = 0; i < 5; i++) {
			scheduledThreadPool.execute(r3);
		}
	}
}
