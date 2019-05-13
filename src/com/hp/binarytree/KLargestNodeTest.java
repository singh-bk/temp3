package com.hp.binarytree;

import java.util.Stack;

public class KLargestNodeTest {
	private static Stack<BinaryNode> stack = new Stack<BinaryNode>();
	public static void main(String[] args){
		BinaryNode root = new BinaryNode(30);
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
		
		PopulateStackInOrder(root);
		System.out.println(stack.size());
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getValue()+" ");
		}
		System.out.println();
		Stack<BinaryNode> stack2 = new Stack<BinaryNode>();
		stack2 = PopulateStackInOrder(root, stack2);
		System.out.println(stack2.size());
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().getValue()+" ");
		}
	}
	
	/**
	 * @param node
	 */
	public static void PopulateStackInOrder(BinaryNode node){
		if(node.getLeft() != null){
			PopulateStackInOrder(node.getLeft());
		}
		System.out.print(node.getValue()+" ");
		stack.push(node);
		if(node.getRight() != null){
			PopulateStackInOrder(node.getRight());
		}
	}
	
	public static Stack<BinaryNode> PopulateStackInOrder(BinaryNode node, Stack<BinaryNode> stack){
		if(node.getLeft() != null){
			PopulateStackInOrder(node.getLeft(), stack);
		}
		System.out.print(node.getValue()+" ");
		stack.push(node);
		if(node.getRight() != null){
			PopulateStackInOrder(node.getRight(), stack);
		}
		
		return stack;
	}
	
}
