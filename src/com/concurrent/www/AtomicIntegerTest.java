package com.concurrent.www;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static void main(String[] args){
		
		AtomicInteger atomic = new AtomicInteger(1);
		System.out.println("value of atomic:"+atomic.get());
		
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future fut1 = executor.submit(new AtomicIntegerRunnableImpl(){});
		Future fut2 = executor.submit(new AtomicIntegerRunnableImpl(){});
		Future fut3 = executor.submit(new AtomicIntegerRunnableImpl(){});
		Future fut4 = executor.submit(new AtomicIntegerRunnableImpl(){});
		Future fut5 = executor.submit(new AtomicIntegerRunnableImpl(){});
		Future fut6 = executor.submit(new AtomicIntegerRunnableImpl(){});
		
		executor.shutdown();
	}
	
}
