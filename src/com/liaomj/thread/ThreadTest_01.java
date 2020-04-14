package com.liaomj.thread;

class MyThread extends Thread{
	public void run() {
		System.out.println(getName()+"该线程正在执行!");
	}
}

/*
 * 默认情况下CPU的线程执行顺序是随机的
 */

public class ThreadTest_01 {
	public static void main(String[] args) { //主线程
		System.out.println("主线程1");
		MyThread mt = new MyThread();
		mt.start(); //启动mt线程
		System.out.println("主线程2");
	}

}
