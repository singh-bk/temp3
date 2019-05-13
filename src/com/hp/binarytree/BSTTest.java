package com.hp.binarytree;

public class BSTTest {

	public static void main(String...args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(7);
		bst.insert(13);
		bst.insert(11);
		bst.insert(12);
		bst.insert(14);
		bst.insert(15);
		bst.insert(16);
		bst.insert(5);
		bst.insert(8);
		bst.insert(21);
		bst.insert(19);
		System.out.println(bst.getRoot().getData());
		bst.preorderDisplay(bst.getRoot());
		System.out.println("In order");
		bst.inorderDisplay(bst.getRoot());
		bst.deleteNode(null, bst.getRoot(), 13);
		
		System.out.println("In order");
		bst.inorderDisplay(bst.getRoot());
	}
}
