package com.video.www;

public class ListNode<T> {

	private T elem;
	private ListNode<T> next;
	
	/**
	 * Default constructor.
	 * Do not initialize any value.
	 */
	public ListNode(){
		
	}
	/**
	 * Constructor to create a Node with element t.
	 * next is set to null to default
	 * @param t
	 */
	public ListNode(T elem){
		this.elem = elem;
		this.next = null;
	}
	
	/**
	 * @return
	 */
	public T getElement(){
		return this.elem;
	}
	
	/**
	 * @return
	 */
	public ListNode<T> getNextElement(){
		return this.next;
	}
	
	/**
	 * @param node
	 */
	public void setNextElement(ListNode<T> node){
		this.next = node;
	}
}
