package com.hp.test;

import java.util.Stack;

public class LinkedListTest {

	public static void main(String... args)
	{
		LinkedList list1 = new LinkedList();
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		int size1= list1.size();
		Stack<Node> stack1 = new Stack<Node>();
		Node node = list1.getFirst();
		while(node!=null)
		{
			stack1.push(node);
			node = node.next;
		}
		LinkedList list2 = new LinkedList();
		list2.add(9);
		list2.add(9);
		int size2 = list2.size();
		Stack<Node> stack2 = new Stack<Node>();
		node = list2.getFirst();
		while(node!=null)
		{
			stack2.push(node);
			node = node.next;
		}
		Stack<Node> stack3 = new Stack<Node>();
		LinkedList sumList = new LinkedList();
		Node sumNode = null;
		int size = 0;
		if(size1 > size2)
		{
			size=size1;
		}
		else
		{
			size=size2;
		}
		int carry =0;
		for(int i=0;i<size;i++)
		{
			int sumData = 0;
			if(stack2.empty())
				sumData = ((Node)stack1.pop()).data + carry;
			else if(stack1.empty())
					sumData = ((Node)stack2.pop()).data + carry;
			else
				sumData = ((Node)stack2.pop()).data + ((Node)stack1.pop()).data + carry;
			if(sumData >= 10)
			{
				carry = 1;
				sumData = sumData%10;
			}
			else
			{
				carry =0;
			}
			sumNode = new Node(sumData,null);
			stack3.push(sumNode);
		}
		if(carry ==1)
		{
			sumNode = new Node(1,null);
			stack3.push(sumNode);
		}
		while(!stack3.isEmpty())
		{
			sumList.add(((Node)stack3.pop()).data);
		}
		System.out.println("The sum List");
		sumList.iterate();
	}
}
