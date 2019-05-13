package com.thread.www;

public class ThreadSafeTest {

	public static void main(String[] args) throws InterruptedException{
		ThreadSafe obj = new ThreadSafe();
		Thread thread1 = new Thread(new Thread1(obj));
		Thread thread2 = new Thread(new Thread2(obj));
		
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
	}
}

