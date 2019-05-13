package com.concurrent.www;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Integer> sharedQ = null;
	public Producer(BlockingQueue<Integer> sharedQ){
		this.sharedQ = sharedQ;
	}
	@Override
	public void run() {
		try {
			for(int i=0;i<20;i++){
				sharedQ.put(i);
				System.out.println("Producer "+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
