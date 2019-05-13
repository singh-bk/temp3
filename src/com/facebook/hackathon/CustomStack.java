package com.facebook.hackathon;

import java.util.Arrays;

public class CustomStack<E> {

	private int size=0;
	private Object elements[];
	public static final int DEFAULT_CAPACITY=10;
	public CustomStack()
	{
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public void push(E element)
	{
		if(size == DEFAULT_CAPACITY)
		{
			ensureCapacity();
		}
		elements[size++] =element;
	}
	
	public E pop()
	{
		@SuppressWarnings("unchecked")
		E e = (E) elements[--size];
		elements[size] = null;
		return e;
	}
	
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public int size()
	{
		return size;
	}
	private void ensureCapacity()
	{
		int newSize = size*2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	
}
