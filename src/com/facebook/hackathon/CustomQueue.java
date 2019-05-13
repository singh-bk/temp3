package com.facebook.hackathon;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class CustomQueue<E> {

	private int QUEUE_CAPACITY = 10;
	
	private AtomicInteger size;

	private Node<E> head;
	private Node<E> tail;
	
	private ReentrantLock putLock = new ReentrantLock();
	private ReentrantLock getLock = new ReentrantLock();
	
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
				putLock.lock();
				tail = elem;
				head = elem;
				putLock.unlock();
			}else{
				putLock.lock();
				tail.next = elem;
				tail = elem;
				putLock.unlock();
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
			Node<E> node = head;
			head = head.next;
			size.getAndDecrement();
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
