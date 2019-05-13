package com.goldman.interview;

import java.util.LinkedList;

import com.hp.binarytree.BinaryNode;

public class CommonAncestorTest {

	static LinkedList<BinaryNode> ancestor1 = new LinkedList<BinaryNode>();
	static LinkedList<BinaryNode> ancestor2 = new LinkedList<BinaryNode>();
	public static void main(String[] args){
		BinaryNode root = new BinaryNode(300);
		BinaryNode node1 = new BinaryNode(23);
		BinaryNode node2 = new BinaryNode(56);
		BinaryNode node3 = new BinaryNode(20);
		BinaryNode node4 = new BinaryNode(27);
		BinaryNode node5 = new BinaryNode(40);
		BinaryNode node6 = new BinaryNode(65);
		BinaryNode node7 = new BinaryNode(77);
		BinaryNode nodeX = new BinaryNode(74);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node6.setRight(node7);
		
		GetAncestors(ancestor1, root, node7);
		System.out.println(ancestor1.size());
	}
	
	/**
	 * 
	 * @param node
	 */
	public static boolean GetAncestors(LinkedList<BinaryNode> ancestors, BinaryNode root, BinaryNode node){
		if(root == null)
			return false;
		else if(root.getValue() == node.getValue())
		{
			ancestors.add(root);
			return true;
		}
		else if(GetAncestors(ancestors, root.getLeft(), node) || GetAncestors(ancestors, root.getRight(), node))
		{
			ancestors.add(root);
			return true;
		}
		return false;
	}
}
