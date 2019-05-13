package com.concurrent.www;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> sharedQ;
	public Consumer(BlockingQueue<Integer> sharedQ){
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run(){
		try{
		for(int i=0;i<20;i++){
			int temp = sharedQ.take();
			System.out.println("Consumer "+i+":"+temp);
		}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
