package com.hp.binarytree;

import java.util.Stack;

public class TreePathTest {

	public static void main(String[] args) {
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
		printAllPath(root);
	}
	
	/**
	 * Algorithm
	 * 		Keep adding elements of the left recursively
	 * @param root
	 */
	public static void printAllPath(BinaryNode root){
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		Stack<BinaryNode> list = new Stack<BinaryNode>();
		BinaryNode lastPopped = null;
		stack.add(root);
		list.add(root);
		BinaryNode current = root;
		
		while(stack != null && !stack.isEmpty() && current != null){
			if(current.getLeft() != null){
				current = current.getLeft();
				if(current != lastPopped){
					stack.add(current);
					list.add(current);
				}else{
					if(current.getRight() != null){
						current = current.getRight();
						stack.add(current);
						list.add(current);
					}
					else{
						lastPopped = stack.pop();
						if(!stack.isEmpty()){
							current = stack.peek();
						}else{
							current = null;
						}
					}
				}
				
			}else if(current.getRight() != null){
				current = current.getRight();
				if(current != lastPopped){
					stack.add(current);
					list.add(current);
				}else{
					System.out.println(stack.toString());
					lastPopped = stack.pop();
					if(!stack.isEmpty()){
						current = stack.peek();
					}else{
						current = null;
					}
				}
			}else{
				System.out.println(stack.toString());
				lastPopped = stack.pop();
				if(!stack.isEmpty()){
					current = stack.peek();
				}else{
					current = null;
				}
			}
		}
	}
}
