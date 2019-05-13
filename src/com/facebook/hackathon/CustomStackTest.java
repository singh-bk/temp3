package com.facebook.hackathon;

public class CustomStackTest {

	public static void main(String[] args)
	{
		CustomStack<Integer> stack = new CustomStack<Integer>();
		stack.push(100);
		stack.push(200);
		while(!stack.isEmpty())
		{
			System.out.println("Element:"+stack.pop());
		}
		System.out.println("size of stack:"+stack.size());
	}
	 
}
