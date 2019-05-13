package com.hp.test;

public class ReverseLinkedListTest {

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		Node first = new Node(1,null);
		Node second = new Node(2,null);
		Node third = new Node(3, null);
		Node fourth = new Node(4, null);
		Node fifth = new Node(5, null);
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		list.add(fifth);
		list.iterate();
		System.out.println();
		list.reverse();
		list.iterate();
	}
}
