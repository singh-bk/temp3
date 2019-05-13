package com.hp.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTest {

	public static void main(String[] args)
	{
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
		
		System.out.println(BinaryNode.GetSize(root));
		System.out.println(BinaryNode.GetSize(node1));
		System.out.println(BinaryNode.GetSize(node2));
		System.out.println(BinaryNode.GetSize(node3));
		System.out.println("Height:"+BinaryNode.GetHeight(root));		
		System.out.println("Height:"+BinaryNode.GetHeight(node1));
		
		System.out.println("Diamter:"+BinaryNode.GetDiameter(root));
		
		root.printPreOder();
		System.out.println();
		root.printPostOder();
		System.out.println("InOrder:");
		root.printInOder();
		System.out.println();
		System.out.println("=======Non Recursive in order");
		printInOderNonRecursive(root);
		BinaryNode.BreadthFirstSearch(root);
		System.out.println();
		BinaryNode.RetrieveBinaryTree(root);
		System.out.println();
		System.out.println("===Ancestors");
		List<Integer> ancestors = new ArrayList<Integer>();
		if(BinaryNode.PrintAncestors(root, node6, ancestors));
		else
			System.out.println("no ancestors for the given target");
		System.out.println(ancestors);
		System.out.println();
		System.out.println(BinaryNode.IsBinarySearchTree(root));
	}
	
	public static void printInOderNonRecursive(BinaryNode root){
		BinaryNode node=root;
		Stack<BinaryNode> s=new Stack<BinaryNode>();
		while(!s.isEmpty()||node!=null){
			if(node!=null){
				s.push(node);
				node=node.getLeft();
			}else{
				System.out.print(s.peek().getValue()+" ");
				node=s.pop().getRight();
			}
		}
		System.out.println();
	}
}
