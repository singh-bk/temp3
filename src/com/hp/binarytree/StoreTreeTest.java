package com.hp.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class StoreTreeTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(30);
		BinaryNode node1 = new BinaryNode(23);
		BinaryNode node2 = new BinaryNode(56);
		BinaryNode node3 = new BinaryNode(20);
		BinaryNode node4 = new BinaryNode(27);
		BinaryNode node5 = new BinaryNode(40);
		BinaryNode node6 = new BinaryNode(65);
		BinaryNode node7 = new BinaryNode(60);
		BinaryNode node8 = new BinaryNode(77);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node6.setLeft(node7);
		node6.setRight(node8);
		System.out.println(GetDepth(root,-1));
		StoreTree(root);
	}
	
	public static int GetDepth(BinaryNode node, int depth){
		if(node == null)
			return depth;
		else{
			depth++;
			return Math.max(GetDepth(node.getLeft(), depth), GetDepth(node.getRight(),depth));
		}
	}
	
	public static LinkedList<Integer> StoreTree(BinaryNode root){
		LinkedList<Integer> tree = new LinkedList<Integer>();
		Queue<BinaryNode> queue1 = new LinkedList<BinaryNode>();
		Queue<BinaryNode> queue2 = new LinkedList<BinaryNode>();
		queue1.add(root);
		int temp = 0;
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			System.out.println();
			while(!queue1.isEmpty())
			{
				BinaryNode node = queue1.remove();
				System.out.print(node.getValue()+" ");
				if(node.getLeft() != null){
					queue2.add(node.getLeft());
				}
				if(node.getRight() != null){
					queue2.add(node.getRight());
				}
			}
			System.out.println();
			while(!queue2.isEmpty()){
				BinaryNode node = queue2.remove();
				System.out.print(node.getValue()+" ");
				
				if(node.getLeft() != null){
					queue1.add(node.getLeft());
				}
				if(node.getRight() != null){
					queue1.add(node.getRight());
				}
			}
		}
		
		return tree;
	}
}
