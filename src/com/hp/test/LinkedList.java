package com.hp.test;

public class LinkedList {

	private Node head = null;
	private int size = 0;
	
	
	public LinkedList()
	{
		this.head = null;
		this.size = 0;
	}
	
	/*
	 * Get the last element of the list
	 */
	
	public Node getLast()
	{
		Node node = this.head;
		while(node.next!=null)
		{
			node = node.next;
		}
		return node;
	}
	/*
	 * Add a int value at the end of the list
	 */
	public synchronized void add(int value)
	{
		Node node = new Node(value,null);
		if(this.head == null)
		{
			head = node;
			size++;
		}
		else
		{
			Node last = this.getLast();
			last.next = node;
			size++;
		}
	}
	
	/*
	 * Add a node at the end of the list
	 */
			
	public  synchronized void add(Node node)
	{
		if(this.head ==null)
		{
			head = node;
			size++;
		}
		else
		{
			Node last = this.getLast();
			last.next = node;
			size++;
		}
	}
	
	public void insertBeginning(Node node)
	{
		Node head = this.head;
		this.head = node;
		node.next = head;
		this.size++;
	}
	
	/*
	 * Get the size of the linkedlist
	 */
	public int size()
	{
		return size;
	}
	
	/*
	 * iterate over the elements of the list
	 */
	public void iterate()
	{
		if(head ==null)
		{
			System.out.println("There are no elements in the list");
		}
		else
		{
			Node node = this.head;
			int count =0;
			while(node != null && count<this.size)
			{
				System.out.print(node.data);
				node = node.next;
				count++;
			}
		}
	}
	
	/*
	 * Return the first element of the list
	 */
	public Node getFirst()
	{
		return head;
	}
	
	public void reverse()
	{
		Node current = this.head;
		head = null;
		while(current != null)
		{
			Node temp = current;
            current = current.next;
            temp.next = head;
            head = temp;
		}
	}
}
