package com.concurrent.www;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {

	public static void main(String[] args){
		BlockingQueue<Integer> sharedQ = new ArrayBlockingQueue<Integer>(5);
 		Producer producer = new Producer(sharedQ);
 		Consumer consumer = new Consumer(sharedQ);
 		
 		new Thread(producer).start();
 		new Thread(consumer).start();
 		
	}
}
