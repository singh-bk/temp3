package com.oracle.www;

import java.util.Stack;

import com.hp.binarytree.BinaryNode;

public class BSTSumReplaceTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(70);
		BinaryNode node1 = new BinaryNode(50);
		BinaryNode node2 = new BinaryNode(90);
		BinaryNode node3 = new BinaryNode(40);
		BinaryNode node4 = new BinaryNode(60);
		BinaryNode node5 = new BinaryNode(80);
		BinaryNode node6 = new BinaryNode(100);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
	
		Stack<Integer> stack = new Stack<Integer>();
		root.printInOderReverse(stack);
		System.out.println();
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		root.printReplaceSumBST(0);
		System.out.println();
		root.printInOder();
	}
	
	public static Stack<BinaryNode> PopulateStack(BinaryNode root){
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		BinaryNode node = root;
		while(node.getRight() != null)
			node = node.getRight();
		stack.push(node);
		return stack;
	}
	
	
}
