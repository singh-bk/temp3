package com.geekforgeeks.www;

import com.hp.binarytree.BinaryNode;


public class RootDistanceTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(300);
		BinaryNode node1 = new BinaryNode(23);
		BinaryNode node2 = new BinaryNode(56);
		BinaryNode node3 = new BinaryNode(20);
		BinaryNode node4 = new BinaryNode(27);
		BinaryNode node5 = new BinaryNode(40);
		BinaryNode node6 = new BinaryNode(65);
		BinaryNode node7 = new BinaryNode(77);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node6.setRight(node7);
		
		//FindDistance(root, 0);
		PrintKDistance(node1, 3);
	}

	public static void FindDistance(BinaryNode node, int distance)
	{
		if(node.getLeft() != null)
		{
			distance++;
			FindDistance(node.getLeft(), distance);
		}
		System.out.println(node.getValue()+" "+distance+" ");
		distance = distance -2;
		if(node.getRight() != null)
		{
			distance++;
			FindDistance(node.getRight(), distance);			
		}
	}
	
	public static void PrintKDistance(BinaryNode node, int distance){
		if(node == null)
		{
			return;
		}
		else if(distance==0)
		{
			System.out.print(node.getValue()+" ");
		}
		else
		{
			PrintKDistance(node.getLeft(), distance-1);
			PrintKDistance(node.getRight(), distance-1);
		}
	}
}
