package com.ardendertat.www;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.hp.binarytree.BinaryNode;

public class TreeLevelOrderPrintTest {

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
		TreeLevelOrderPrint(root);
		
	}
	
	/**
	 * Maintain two queues
	 * 	populate queue1 with nodes from depth 0,2,4,6 etc
	 * 	populate queue2 with nodes from depth 1,3,5,7 etc
	 * @param root
	 */
	public static void TreeLevelOrderPrint(BinaryNode root){
		BinaryNode node = root;
		Queue<BinaryNode> queue1 = new LinkedList<BinaryNode>();
		Queue<BinaryNode> queue2 = new LinkedList<BinaryNode>();
		queue1.add(root);
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(!queue1.isEmpty())
			{
				System.out.println();
				while(!queue1.isEmpty())
				{
					node = queue1.remove();
					System.out.print(node.getValue()+" ");
					if(node.getLeft()!= null){
						queue2.add(node.getLeft());
					}
					if(node.getRight()!= null){
						queue2.add(node.getRight());
					}
				}
			}
			if(!queue2.isEmpty())
			{
				System.out.println();
				while(!queue2.isEmpty())
				{
					node = queue2.remove();
					System.out.print(node.getValue()+" ");
					if(node.getLeft()!= null){
						queue1.add(node.getLeft());
					}
					if(node.getRight()!= null){
						queue1.add(node.getRight());
					}
				}
			}
		}
	}
	
	/**
	 * Maintain two stacks
	 * 	Do a breadth first traversal and add nodes to the stack.
	 * 	Add no of elements at each level to the stack2
	 * Queue is needed for Breadth First Traversal
	 * @param root
	 */
	public static void TreeLevelOrderPrintReverse(BinaryNode root){
		BinaryNode node = root;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int count = 0;
		stack1.push(node);
		stack2.push(1);
		queue.add(node);
	
		while(!queue.isEmpty()){
			node = queue.remove();
			if(node.getLeft() != null){
				queue.add(node.getLeft());
				stack1.push(node.getLeft());
			}
			//if(node.getRight() != null)
		}
		
	}
}
