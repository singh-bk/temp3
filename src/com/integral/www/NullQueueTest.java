package com.integral.www;

import java.util.LinkedList;
import java.util.Queue;

public class NullQueueTest {

	public static void main(String[] args)
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add(null);
		queue.add(null);
		System.out.println(queue.size());
	}
}
