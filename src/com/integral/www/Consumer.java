package com.integral.www;

import java.util.Queue;

public class Consumer implements Runnable{
	private Queue<Integer> sharedQ;
	//size of the shared queue
	private int SIZE;
	
	public Consumer(Queue<Integer> sharedQ, int size)
	{
		this.sharedQ = sharedQ;
		this.SIZE = size;
	}

	@Override
	public void run() {
		while(true)
		{
			try
			{
				System.out.println("Consumed"+consume());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public int consume() throws InterruptedException
	{
		/*
		 * wait if the queue is empty
		 * Acquire the lock on the queue
		 * wait;
		 */
		while(sharedQ.isEmpty())
		{
			synchronized(sharedQ)
			{
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQ.size());
				sharedQ.wait();
			}
		}
		
		/*
		 * Acquire the lock on the queue
		 * 
		 */
		synchronized(sharedQ)
		{
			sharedQ.notifyAll();
			return sharedQ.remove();
		}
	}
	
}
