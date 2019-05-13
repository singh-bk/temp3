package com.facebook.hackathon;

public class CustomQueue<E> {

	private Object elements[];
	private static final int QUEUE_CAPACITY=10;
	private int size;
	
	public CustomQueue()
	{
		elements = new Object[QUEUE_CAPACITY];
	}
	
	public void enqueue(E element)
	{
		if(size == QUEUE_CAPACITY)
		{
			System.out.println("The queue is already full");
		}
		element[]
	}
}
