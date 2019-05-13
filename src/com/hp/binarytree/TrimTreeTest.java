package com.hp.binarytree;

public class TrimTreeTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(8);
		BinaryNode node1 = new BinaryNode(3);
		BinaryNode node2 = new BinaryNode(10);
		BinaryNode node3 = new BinaryNode(1);
		BinaryNode node4 = new BinaryNode(6);
		BinaryNode node5 = new BinaryNode(14);
		BinaryNode node6 = new BinaryNode(4);
		BinaryNode node7 = new BinaryNode(7);
		BinaryNode node8 = new BinaryNode(13);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node4.setLeft(node6);
		node4.setRight(node7);
		node2.setRight(node5);
		node5.setLeft(node8);
		
		BinaryNode root2 = TrimTree(root,5,13);
		PrintInorder(root2);
	}
	
	/**
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	public static BinaryNode TrimTree(BinaryNode node, int min, int max){
		if(node.getLeft() != null){
			node.setLeft(TrimTree(node.getLeft(),min,max));
		}
		if(node.getRight() != null){
			node.setRight(TrimTree(node.getRight(),min,max));
		}
		if(node.getValue()<min){
			return node.getRight();
		}
		else if(node.getValue()>max){
			return node.getLeft();
		}
		else{
			return node;
		}
	}
	
	/**
	 * @param node
	 */
	public static void PrintInorder(BinaryNode node){
		if(node.getLeft() != null)
			PrintInorder(node.getLeft());
		System.out.print(node.getValue()+" ");
		if(node.getRight() != null)
			PrintInorder(node.getRight());
	}
}
