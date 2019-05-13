package com.hp.test;

public class LinkedListTest2 {

	public static void main(String... args)
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
		list.insertBeginning(fifth);
		list.iterate();
		
		Node head = list.getFirst();
		Node node1 = head.next;
		Node node2 = head.next.next;
		boolean hasLoop = false;
		while(head!=null)
		{
			if(node1==node2)
			{
				hasLoop = true;
				
				break;
			}

			if(node1.next != null)
				node1 = node1.next;
			else
				break;
			if(node1.next != null && node1.next.next != null)
				node2=node2.next.next;
			else
				break;
		}
		if(hasLoop)
		{
			System.out.println("There is a loop");
		}
		else
		{
			System.out.println("There is no loop");
		}
	}
}
