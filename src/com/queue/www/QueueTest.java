package com.queue.www;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(5);
		queue.enqueue(5);
		queue.dequeue();
		queue.print();
	}
}
