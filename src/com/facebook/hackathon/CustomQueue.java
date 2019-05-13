package com.facebook.hackathon;


public class CustomQueue<E> {

	private int QUEUE_CAPACITY = 10;
	private int size;

	private Node<E> head;
	private Node<E> tail;

	public CustomQueue(int capacity) {
		QUEUE_CAPACITY = capacity;
		this.size = 0;
	}

	public boolean enqueue(E element) {
		if (size == QUEUE_CAPACITY) {
			System.out.println("The queue is already full");
			return false;
		} else {
			Node<E> elem = new Node<E>(element);
			if(size == 0){
				tail = elem;
				head = elem;
			}else{
				tail.next = elem;
				tail = elem;
			}
			size++;
			return true;
		}
	}

	public E dequeue() {
		if (size == 0) {
			System.out.println("The queue is empty");
			return null;
		} else {
			Node<E> node = head;
			head = head.next;
			size--;
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
