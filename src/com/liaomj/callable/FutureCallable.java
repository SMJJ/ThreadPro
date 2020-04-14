package com.liaomj.callable;

import com.liaomj.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Calable_Task implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(CurrentTime.currentTime()+"子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
}


public class FutureCallable {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Calable_Task task = new Calable_Task();
		Future<Integer> result = executor.submit(task);
		executor.shutdown();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(CurrentTime.currentTime()+"主线程在执行任务");
		try {
			System.out.println(CurrentTime.currentTime()+"task运行结果"+result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(CurrentTime.currentTime()+"所有任务执行完毕");
		
	}	
}
