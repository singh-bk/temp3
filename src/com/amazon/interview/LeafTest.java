package com.amazon.interview;

import java.util.Stack;

import com.hp.binarytree.BinaryNode;

public class LeafTest {

	private static int leafDepth = -1;
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
		//PrintLeaves(root,0);
		PrintLeavesWithoutRecursion(root);
	}
	
	
	/**
	 * Check if leaves are of same depth recursively
	 * @param node
	 * @param depth
	 */
	public static void PrintLeaves(BinaryNode node, int depth){
		if(node == null){
			return;
		}
		if(node.getLeft() == null && node.getRight() == null){
			System.out.print(node.getValue()+" "+depth+" ");
			if(leafDepth == -1)
				leafDepth = depth;
			else if(depth!= leafDepth){
				System.out.println("Not same level");
			}
			return;
		}
		depth = depth+1;
		PrintLeaves(node.getLeft(),depth);
		PrintLeaves(node.getRight(),depth);
	}
	
	/**
	 * @param root
	 * @param depth
	 */
	public static void PrintLeavesWithoutRecursion(BinaryNode root){
		Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
		Stack<BinaryNode> stack2 = new Stack<BinaryNode>();
		stack1.push(root);
		int count = -1;
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{
			if(!stack1.isEmpty())
			{
				count++;
				while(!stack1.isEmpty())
				{
					BinaryNode node = stack1.pop();
					if(node.getLeft() == null && node.getRight() == null)
					{
						System.out.print(node.getValue()+" "+count+" ");
					}
					else{
						if(node.getLeft() != null){
							stack2.push(node.getLeft());
						}
						if(node.getRight() != null){
							stack2.push(node.getRight());
						}
					}
				}
			}
			if(!stack2.isEmpty())
			{
				count++;
				while(!stack2.isEmpty())
				{
					BinaryNode node = stack2.pop();
					if(node.getLeft() == null && node.getRight() == null)
					{
						System.out.print(node.getValue()+" "+count+" ");
					}
					else{
						if(node.getLeft() != null){
							stack1.push(node.getLeft());
						}
						if(node.getRight() != null){
							stack1.push(node.getRight());
						}
					}
				}
			}
		}
	}
}
