package com.concurrentutil.java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException{
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);
		queue.add("One");
		queue.add("One");
		queue.add("One");
		queue.add("One");
		queue.add("One");
		//queue.offer("One");
		queue.offer("One",3, TimeUnit.SECONDS);
		queue.take();
		System.out.println(queue.size());
	}
}
