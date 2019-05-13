package com.olacabs.www;

import com.hp.binarytree.TreeNode;

public class RecusrionTest {
	
	private static int MAX_VAL = 99999;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100, null, null);
		TreeNode node1 = new TreeNode(60, null, null);
		TreeNode node2 = new TreeNode(180, null, null);
		TreeNode node3 = new TreeNode(30, null, null);
		TreeNode node4 = new TreeNode(80, null, null);
		TreeNode node5 = new TreeNode(140, null, null);
		TreeNode node6 = new TreeNode(200, null, null);
		TreeNode node7 = new TreeNode(10, null, null);
		TreeNode node8 = new TreeNode(50, null, null);
		TreeNode node9 = new TreeNode(70, null, null);
		TreeNode node10 = new TreeNode(90, null, null);
		TreeNode node11 = new TreeNode(120, null, null);
		TreeNode node12 = new TreeNode(160, null, null);
		TreeNode node13 = new TreeNode(40, null, null);

		root.setLeftNode(node1);
		root.setRightNode(node2);
		node1.setLeftNode(node3);
		node1.setRightNode(node4);
		node2.setLeftNode(node5);
		node2.setRightNode(node6);
		node3.setLeftNode(node7);
		node3.setRightNode(node8);
		node4.setLeftNode(node9);
		node4.setRightNode(node10);
		node5.setLeftNode(node11);
		node5.setRightNode(node12);
		node8.setLeftNode(node13);
		System.out.println(isBinaryTreeRecursivly(root, 0, MAX_VAL));
		System.out.println(getDepthRecursively(root, 0));
		
		printInOderRecursively(root);
		System.out.println();
		printDepthOfNodeRecursively(root, 0);
		createMirrorRecursively(root);
		printInOderRecursively(root);
		System.out.println();
		dfsRecursively(root, 120);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isBinaryTreeRecursivly(TreeNode node, int min, int max) {

		if ((node.getLeftNode() != null && (node.getLeftNode().getData() > node
				.getData() || node.getLeftNode().getData() < min))
				|| (node.getRightNode() != null && (node.getRightNode()
						.getData() < node.getData() || node.getRightNode().getData() > max))) {
			return false;
		} else if (node.getLeftNode() != null && node.getRightNode() != null) {
			return isBinaryTreeRecursivly(node.getLeftNode(), min, node.getData())
					&& isBinaryTreeRecursivly(node.getRightNode(), node.getData(), max);
		} else if (node.getLeftNode() != null) {
			return isBinaryTreeRecursivly(node.getLeftNode(), min, node.getData());
		} else if (node.getRightNode() != null) {
			return isBinaryTreeRecursivly(node.getRightNode(), node.getData(), max);
		} else {
			return true;
		}
	}
	

	/**
	 * s
	 * @param node
	 * @param depth
	 * @return
	 */
	public static int getDepthRecursively(TreeNode node, int depth){
		if (node == null) {
			return depth;
		} else {
			depth++;
			if (node.getRightNode() == null && node.getLeftNode() == null) {
				return depth;
			} else {
				return Math.max(getDepthRecursively(node.getLeftNode(), depth),
								getDepthRecursively(node.getRightNode(), depth));
			}
		}
	}
	/**
	 * s
	 * @param node
	 */
	public static void printInOderRecursively(TreeNode node){
		if(node.getLeftNode() != null){
			printInOderRecursively(node.getLeftNode());
		}
		System.out.print(node.getData()+" ");
		if(node.getRightNode() != null){
			printInOderRecursively(node.getRightNode());
		}
	}
	
	public static void printDepthOfNodeRecursively(TreeNode node, int depth){
		if(node == null){
			return;
		}else{
			depth++;
			printDepthOfNodeRecursively(node.getLeftNode(), depth);
			System.out.println("node:"+node.getData()+" depth:"+depth);
			
			printDepthOfNodeRecursively(node.getRightNode(), depth);
		}
	}
	
	public static void dfsRecursively(TreeNode node, int value){
		if(node.getData() == value){
			System.out.println("found");
		}else{
			System.out.print(node.getData()+ " ");
			if(node.getLeftNode() != null){
				dfsRecursively(node.getLeftNode(), value);
			}
			if(node.getRightNode() != null){
			dfsRecursively(node.getRightNode(), value);
			}
		}
	}
	
	public static void createMirrorRecursively(TreeNode node){
		TreeNode left = node.getLeftNode();
		TreeNode right = node.getRightNode();
		node.setLeftNode(right);
		node.setRightNode(left);
		if(left != null){
			createMirrorRecursively(left);
		}
		if(right != null){
			createMirrorRecursively(right);
		}
	}
	
}
