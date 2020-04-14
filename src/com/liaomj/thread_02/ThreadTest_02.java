package com.liaomj.thread_02;

class MyThread extends Thread{
	public MyThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(getName()+"正在运行"+i);
		}
	}
}

public class ThreadTest_02 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		t1.start();
		t2.start();
	}
}

