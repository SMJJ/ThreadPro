package com.liaomj.runnable;

class PrintRunnable implements Runnable{
	int i = 0;
	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName()+"正在运行");
		while(i<=10) {
			System.out.println(Thread.currentThread().getName()+"正在运行"+(i++));
		}
	}
	
}

public class Test {
	public static void main(String[] args) {
//		PrintRunnable r1 = new PrintRunnable();
//		Thread t1 = new Thread(r1);
//		t1.start();
//		PrintRunnable r2 = new PrintRunnable();
//		Thread t2 = new Thread(r2);
//		t2.start();
		
		// 线程共享，多个线程执行同一个任务
		PrintRunnable r3 = new PrintRunnable();
		Thread t3 = new Thread(r3);
		t3.start();
		Thread t4 = new Thread(r3);
		t4.start();
	}
}
