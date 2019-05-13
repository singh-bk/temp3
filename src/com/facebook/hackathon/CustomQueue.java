package com.facebook.hackathon;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class CustomQueue<E> {

	private int QUEUE_CAPACITY = 10;
	
	private AtomicInteger size;

	private Node<E> head;
	private Node<E> tail;
	
	private ReentrantLock headLock = new ReentrantLock();
	private ReentrantLock tailLock = new ReentrantLock();
	
	public CustomQueue(int capacity) {
		QUEUE_CAPACITY = capacity;
		this.size = new AtomicInteger(0);
	}

	public boolean enqueue(E element) {
		if (size.get() == QUEUE_CAPACITY) {
			System.out.println("The queue is already full");
			return false;
		} else {
			Node<E> elem = new Node<E>(element);
			if(size.get() == 0){
				headLock.lock();
				tailLock.lock();
				tail = elem;
				head = elem;
				headLock.unlock();
				tailLock.unlock();
			}else{
				tailLock.lock();
				tail.next = elem;
				tail = elem;
				tailLock.unlock();
			}
			size.getAndIncrement();
			return true;
		}
	}

	public E dequeue() {
		if (size.get() == 0) {
			System.out.println("The queue is empty");
			return null;
		} else {
			headLock.lock();
			Node<E> node = head;
			head = head.next;
			size.getAndDecrement();
			headLock.unlock();
			return node.item;
		}
	}
	
	public void print(){
		int seed = 0;
		Node<E> node = head;
		while(node != null){
			System.out.println(node.item);
			node = node.next;
		}
	}
}
