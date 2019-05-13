package com.hp.binarytree;

import java.util.Stack;

public class CreateMirrorTest {

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
		PrintInorder(root);
		//CreateMirror(root);
		CreateMirrorWithoutRecursion(root);
		//BinaryNode root2 = CreateMirrorWithoutRecursionAndPreserveTree(root);
		System.out.println();
		PrintInorder(root);
		System.out.println();
		//PrintInorder(root2);
		
	}
	
	/**
	 * Create mirror using recursion
	 * Modifies the tree
	 * @param node
	 */
	public static void CreateMirror(BinaryNode node){
		if(node == null){
			return;
		}
		else
		{
			CreateMirror(node.getLeft());
			CreateMirror(node.getRight());
			
			BinaryNode left = node.getLeft();
			BinaryNode right = node.getRight();
			
			node.setLeft(right);
			node.setRight(left);
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	public static void CreateMirrorWithoutRecursion(BinaryNode node){
		if(node == null)
			return;
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			node = stack.pop();
			BinaryNode left = node.getLeft();
			BinaryNode right = node.getRight();
			node.setLeft(right);
			node.setRight(left);
			if(node.getRight() != null)
				stack.push(node.getRight());
			if(node.getLeft() != null)
				stack.push(node.getLeft());
		}
	}
	
	/**
	 * @param node
	 */
	public static BinaryNode CreateMirrorWithoutRecursionAndPreserveTree(BinaryNode node){
		BinaryNode root = new BinaryNode(node.getValue());
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			node = stack.pop();
			BinaryNode left = node.getLeft();
			if(left != null)
			{
				BinaryNode left2 = new BinaryNode(left.getValue());
				root.setRight(left2);
			}
			BinaryNode right = node.getRight();
			if(right != null){
				BinaryNode right2 = new BinaryNode(right.getValue());
				root.setLeft(right2);
			}
			if(node.getLeft() != null)
				stack.push(node.getLeft());
			if(node.getRight() != null)
				stack.push(node.getRight());

		}
		return root;
	}
	
	public static void PrintInorder(BinaryNode node){
		if(node == null){
			return;
		}
		PrintInorder(node.getLeft());
		System.out.print(node.getValue()+" ");
		PrintInorder(node.getRight());
	}
	
}
