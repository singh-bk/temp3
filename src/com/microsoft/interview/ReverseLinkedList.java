package com.microsoft.interview;

public class ReverseLinkedList {

	public static void main(String[] args){
		ListNode head = new ListNode(5, null);
		ListNode node1 = new ListNode(4, null);
		ListNode node2 = new ListNode(7, null);
		ListNode node3 = new ListNode(9, null);
		ListNode node4 = new ListNode(11, null);
		ListNode node5 = new ListNode(2, null);
		ListNode node6 = new ListNode(1, null);
		ListNode tail = new ListNode(6, null);
		
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(tail);
		
		/*
		 * Maintain 2 pointers - prev and current. 
		 * in the start - 
		 * 		prev is the head
		 * 		current is the head.next
		 * while current is not null
		 * 		store current.next in another variable temp
		 * 		change current.next to prev.
		 * 		change prev to current 
		 * 		change current to temp 
		 */
		ListNode prev = head;
		ListNode current = head.getNext();
		
		while(current != null)
		{
			ListNode temp = current.getNext();
			current.setNext(prev);
			if(prev == head)
			{
				prev.setNext(null);
			}
			
			prev = current;
			current = temp;
		}
		
		System.out.println();
	}
}
