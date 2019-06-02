package com.queue.www;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Queue<E> {

	AtomicReference<Node<E>> atomicHead = new AtomicReference<Node<E>>();
	AtomicReference<Node<E>> atomicTail = new AtomicReference<Node<E>>();
	Node<E> head;
	Node<E> tail;
	AtomicInteger size;
	int MAX_SIZE;
	
	public Queue(int size){
		this.MAX_SIZE = size;
		this.size = new AtomicInteger();
	}
	
	public void enqueue(E e){
		Node<E> node = new Node<E>(e);
		
		if(atomicHead.get() == null){
			boolean added = atomicHead.compareAndSet(null, node);
			if(added){
				boolean tailAdded = atomicTail.compareAndSet(null, node);
				size.incrementAndGet();
			}else{
				Node<E> currentTail = atomicTail.get();
				currentTail.next = node;
				while(!atomicTail.compareAndSet(currentTail, node)){
					currentTail = atomicTail.get();
					currentTail.next = node;
				}
			}
			
		}else{
			Node<E> currentTail = atomicTail.get();
			currentTail.next = node;
			while(!atomicTail.compareAndSet(currentTail, node)){
				currentTail = atomicTail.get();
				currentTail.next = node;
			}
		}
	}
	
	public E dequeue(){
		Node<E> currentHead = atomicHead.get();
		while(!atomicHead.compareAndSet(currentHead, currentHead.next)){
			currentHead = atomicHead.get();
		}
		size.decrementAndGet();
		currentHead.next = null;
		return currentHead.e;
	}
	
	public void print(){
		Node<E> node = atomicHead.get();
		while(node != null){
			System.out.println(node.e);
			node = node.next;
		}
	
	}
}

class Node<E>{
	E e;
	Node<E> next;
	
	public Node(E e){
		this.e = e;
	}
}
