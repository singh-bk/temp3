package com.hp.test;

public class Node {

	public int data;
	public Node next;
	public int carry = 0;
	
	public Node(int data, Node next)
	{
		this.data = data;
		this.next = next;
		this.carry = 0;
	}
}
