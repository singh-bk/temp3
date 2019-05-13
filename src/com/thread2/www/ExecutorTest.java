package com.thread2.www;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//Future fut = service.submit(new MyRunnable());
		Future fut = service.submit(new CustomCallable());
		System.out.println("This is first line");
		System.out.println(fut.get());
		System.out.println("This is last line");
		service.shutdown();
	}
}
