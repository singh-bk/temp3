package com.integral.www;

import java.util.Queue;

public class Producer implements Runnable{

	private final Queue<Integer> sharedQ;
	//size of the sharedQueue
	private final int SIZE;
	
	public Producer(Queue<Integer> sharedQ, int size)
	{
		this.sharedQ = sharedQ;
		this.SIZE = size;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Produced:"+i);
			try
			{
				produce(i);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	private void produce(int i) throws InterruptedException
	{
		/*
		 * wait if the queue is full
		 * Acquire the lock
		 * Release the lock
		 */
		while(sharedQ.size() == SIZE)
		{
			synchronized(sharedQ)
			{
				System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQ.size());
				sharedQ.wait();
			}
		}
	
		/*
		 * Acquire lock on sharedQ
		 * add an element to the sharedQ
		 * notify all the threads waiting on sharedQ
		 */
		synchronized(sharedQ)
		{
			sharedQ.add(i);
			sharedQ.notifyAll();
		}
	}

}
