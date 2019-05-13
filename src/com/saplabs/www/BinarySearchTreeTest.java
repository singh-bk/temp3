package com.saplabs.www;

public class BinarySearchTreeTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(50);
		BinarySearchTree tree = new BinarySearchTree(root);
		
		BinaryNode node1 = new BinaryNode(120);
		BinaryNode node2 = new BinaryNode(45);
		BinaryNode node3 = new BinaryNode(110);
		BinaryNode node4 = new BinaryNode(30);
		BinaryNode node5 = new BinaryNode(40);
		tree.insert(root, node1);
		tree.insert(root, node2);
		tree.insert(root, node3);
		tree.insert(root, node4);
		tree.insert(root, node5);
		tree.insert(root, node3);
	}
}

