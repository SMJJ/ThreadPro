package com.liaomj.method;

class Runnale_Test implements Runnable{
	int n = 1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int res=0;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		while(n<=10) {
			res = n;
			n ++;
			System.out.println(Thread.currentThread().getName() + "消费了" + res);
		}
	}
}


class Thread_Test extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + "运行" + i +"次");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}

public class Method {
	// Thread test
	public static void normal_test() {
		Thread_Test test = new Thread_Test();  
		test.start();
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + "运行" + i +"次");
		}
	}
	
	// join方法
	public static void join_test() throws InterruptedException {
		Thread_Test test = new Thread_Test(); 
		test.start();
		test.join();
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + "运行" + i +"次");
		}
	}
	
	// sleep方法
	public static void sleep_test() throws InterruptedException{
		Thread_Test test = new Thread_Test(); 
		test.start();
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + "运行" + i +"次");
			Thread.sleep(1000);
		}
	}
	
	// priority
	public static void priority_test() {
		Thread_Test test = new Thread_Test(); 
		test.start();
		Thread.currentThread().setPriority(10);
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + "运行" + i +"次");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		normal_test();
//		join_test();
//		sleep_test();
//		priority_test();
		
		//多线程完成同一个任务，线程不安全-----------------------
		Runnale_Test test = new Runnale_Test();
		Thread t1 = new Thread(test);
		t1.start();
		Thread t2 = new Thread(test);
		t2.start();
		Thread t3 = new Thread(test);
		t3.start();
		//-----------------------------------------------
		

	}
	
}
