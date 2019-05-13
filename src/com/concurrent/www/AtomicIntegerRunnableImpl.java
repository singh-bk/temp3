package com.concurrent.www;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerRunnableImpl implements Runnable{

	public void run(){
		System.out.println("coming here");
		AtomicInteger atomic = AtomicIntegerUtils.Get();
		System.out.println("Thread i:"+Thread.currentThread().getName()+ "atomic:"+atomic.incrementAndGet());
	}
}
