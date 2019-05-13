package com.goldman.interview;

import java.util.Stack;

import com.hp.binarytree.BinaryNode;

public class InOrderWithoutRecursionTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(100);
		BinaryNode node1 = new BinaryNode(10);
		BinaryNode node2 = new BinaryNode(20);
		BinaryNode node3 = new BinaryNode(30);
		BinaryNode node4 = new BinaryNode(40);
		BinaryNode node5 = new BinaryNode(50);
		BinaryNode node6 = new BinaryNode(60);
		BinaryNode node7 = new BinaryNode(70);
		BinaryNode node8 = new BinaryNode(80);
		BinaryNode node9 = new BinaryNode(90);
		BinaryNode node10 = new BinaryNode(110);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node3.setLeft(node7);
		node4.setLeft(node8);
		node4.setRight(node9);
		node5.setRight(node10);
		PrintInOrder(root);
		System.out.println();
		PrintInOrderRecursive(root);
	}
	
	public static void PrintInOrder(BinaryNode root)
	{
		/*
		 * create an empty stack
		 * add root to the stack
		 * set current to root.left
		 * keep adding the left node till you encounter null.- keep updating current
		 * 		pop the last element
		 * 		check if it has right element 
		 */
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(root);
		BinaryNode current = root.getLeft();
		while(true)
		{
			while(current!= null)
			{
				stack.push(current);
				current = current.getLeft();
			}
			if(current == null && !stack.isEmpty())
			{
				BinaryNode node = stack.pop();
				System.out.print(node.getValue()+" ");
				current = node.getRight();
			}
			if(current == null && stack.isEmpty())
			{
				break;
			}
		}
	}
	public static void PrintInOrderRecursive(BinaryNode node)
	{
		if(node.getLeft() != null)
		{
			PrintInOrderRecursive(node.getLeft());
		}
		System.out.print(node.getValue()+" ");
		if(node.getRight() != null)
		{
			PrintInOrderRecursive(node.getRight());
		}
	}
}
