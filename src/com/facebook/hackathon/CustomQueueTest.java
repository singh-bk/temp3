package com.facebook.hackathon;

public class CustomQueueTest {

	public static void main(String[] args) {
		CustomQueue<String> queue = new CustomQueue<String>(10);
		queue.enqueue("BK");
		queue.enqueue("BK");
		queue.enqueue("BK");
		queue.enqueue("BK");
		queue.dequeue();
		queue.dequeue();
		queue.print();
	}
}

