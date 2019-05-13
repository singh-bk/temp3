package com.microsoft.interview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import com.hp.binarytree.BinaryNode;

public class FlattenTreeTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(10);
		BinaryNode node1 = new BinaryNode(12);
		BinaryNode node2 = new BinaryNode(15);
		BinaryNode node3 = new BinaryNode(25);
		BinaryNode node4 = new BinaryNode(30);
		BinaryNode node5 = new BinaryNode(36);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		
		LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
		InOrderTraversal(root, list);
		System.out.println();
		Iterator<BinaryNode> iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next().getValue()+" ");
		}
		System.out.println();
		InOrderTraversalWithoutRecursion(root);
	}
	
	public static void InOrderTraversal(BinaryNode node, LinkedList<BinaryNode> list)
	{
		if(node.getLeft()!= null)
		{
			InOrderTraversal(node.getLeft(), list);
		}
		System.out.print(node.getValue()+" ");
		list.add(node);
		if(node.getRight() != null)
		{
			InOrderTraversal(node.getRight(), list);
		}
	}
	
	public static void InOrderTraversalWithoutRecursion(BinaryNode node)
	{
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(node);
		BinaryNode current = node.getLeft();
		
		while(!(current == null && stack.isEmpty()))
		{
			while(current!=null)
			{
				stack.push(current);
				current = current.getLeft();
			}
			if(current == null && !stack.isEmpty())
			{
				node = stack.pop();
				System.out.print(node.getValue()+" ");
				current = node.getRight();
			}
		}
	}
}
