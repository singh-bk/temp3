package com.hp.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public final class BinaryNode {

	private int data;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	public BinaryNode(int data)
	{
		this(data, null,null);
	}
	
	public BinaryNode(int data, BinaryNode left, BinaryNode right)
	{
		this.data = data;
		this.leftChild = left;
		this.rightChild = right;
	}
	
	public int getValue()
	{
		return this.data;
	}
	
	public void setValue(int data){
		this.data = data;
	}
	
	public BinaryNode getLeft()
	{
		return this.leftChild;
	}
	
	public BinaryNode getRight()
	{
		return this.rightChild;
	}

	public void setLeft(BinaryNode left)
	{
		this.leftChild = left;
	}
	public void setRight(BinaryNode right)
	{
		this.rightChild = right;
	}
	
	public static int GetSize(BinaryNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return (1+ GetSize(root.getLeft()) + GetSize(root.getRight()));
		}
	}
	
	public static int GetHeight(BinaryNode root)
	{
		if(root == null)
		{
			return -1;
		}
		else
		{
			return (1+Math.max(GetHeight(root.getLeft()),GetHeight(root.getRight())));
		}
	}
	
	public static int GetDiameter(BinaryNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return(2+(GetHeight(root.getLeft())+(GetHeight(root.getRight()))));
		}
	}
	
	public void printPreOder()
	{
		System.out.print(this.getValue()+" ");
		if(this.getLeft()!=null)
		{
			this.getLeft().printPreOder();
		}
		if(this.getRight() != null)
		{
			this.getRight().printPreOder();
		}
	}
	public void printPostOder()
	{
		if(this.getLeft()!=null)
		{
			this.getLeft().printPostOder();
		}
		if(this.getRight() != null)
		{
			this.getRight().printPostOder();
		}
		System.out.print(this.getValue()+" ");
	}
	
	public void printInOder()
	{
		if(this.getLeft()!=null)
		{
			this.getLeft().printInOder();
		}
		System.out.print(this.getValue()+" ");
		if(this.getRight() != null)
		{
			this.getRight().printInOder();
		}
	}
	
	/**
	 * reverse of InOder
	 */
	public void printInOderReverse(Stack<Integer> stack)
	{
		if(this.getRight()!=null)
		{
			this.getRight().printInOderReverse(stack);
		}
		System.out.print(this.getValue()+" ");
		stack.push(this.getValue());
		if(this.getLeft() != null)
		{
			this.getLeft().printInOderReverse(stack);
		}
	}
	
	/**
	 * replace every node with the sum of all the nodes greater than the current node
	 */
	public void printReplaceSumBST(int value){
		if(this.getRight() != null){
			this.getRight().printReplaceSumBST(0);
		}
		int val = this.getValue()+value;
		if(this.getRight() != null){
			val = val+this.getRight().getValue();
		}
		this.setValue(val);
		if(this.getLeft() != null){
			this.getLeft().printReplaceSumBST(val);
		}
	}
	
	public static void BreadthFirstSearch(BinaryNode root)
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			BinaryNode node = queue.remove();
			System.out.print(node.getValue()+" ");
			if(node.getLeft()!=null)
				queue.add(node.getLeft());
			if(node.getRight()!=null)
				queue.add(node.getRight());
		}
	}
	
	/*
	 * Method to retreive the binary tree and print it
	 */
	public static void RetrieveBinaryTree(BinaryNode root)
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			BinaryNode node = queue.remove();
			if(node != null)
			{
					System.out.print(node.getValue()+" ");
				if(node.getLeft()!=null)
				{
					queue.add(node.getLeft());
				}
				else
				{
					queue.add(null);
				}
				if(node.getRight()!=null)
				{
					queue.add(node.getRight());
				}
				else
				{
					queue.add(null);
				}
			}
			else
			{
				System.out.print("null"+" ");
			}
		}
	}
	
	public static boolean PrintAncestors(BinaryNode root, BinaryNode target, List<Integer> list)
	{
		  /* base cases */
		  if ( root == null )
		     return false;
		 
		  if ( root.getValue() == target.getValue() )
		     return true;
		 
		  /* If target is present in either left or right subtree of this node,
		     then print this node */
		  if ( PrintAncestors(root.getLeft(), target, list) || PrintAncestors(root.getRight(), target, list) )
		  {
		    System.out.print(root.getValue()+" ");
		    list.add(root.getValue());
		    return true;
		  }
		 
		  /* Else return false */
		  return false;		
	}
	
	public static boolean IsBinarySearchTree(BinaryNode root)
	{
		if(root!= null)
		{
			if((root.getLeft() != null && root.getLeft().getValue()>root.getValue()) || 
					(root.getRight() != null && root.getRight().getValue()<root.getValue()))
			{
				return false;
			}
			else
			{
				return (IsBinarySearchTree(root.getLeft()) && IsBinarySearchTree(root.getRight()));
			}
		}
		return true;
	}
}
