package com.thread.www;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new MyRunnable());
		Thread thread2 = new Thread(new MyRunnable());
		
		Thread.sleep(3000);
		thread.start();
		thread2.start();
	}
}
