package com.liaomj.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.liaomj.util.CurrentTime;

public class FutureTaskCallable {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Calable_Task task = new Calable_Task();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		executor.submit(futureTask);
		executor.shutdown();
		
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
        System.out.println(CurrentTime.currentTime()+"主线程在执行任务");
         
        try {
            System.out.println(CurrentTime.currentTime()+"task运行结果"+futureTask.get()); // 等待有值返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        System.out.println(CurrentTime.currentTime()+"所有任务执行完毕");
    }
}
