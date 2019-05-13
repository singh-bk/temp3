package com.geeksforgeeks.tree;

import com.hp.binarytree.TreeNode;

/**
 * http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
 * @author singhbir
 *
 */
public class RemoveNodesTest {

	static int min = 20;
	public static void main(String[] args){
		TreeNode root = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node8 = new TreeNode(8, null, null);
		TreeNode node9 = new TreeNode(9, null, null);
		TreeNode node10 = new TreeNode(10, null, null);
		TreeNode node11 = new TreeNode(11, null, null);
		TreeNode node12 = new TreeNode(12, null, null);
		TreeNode node13 = new TreeNode(13, null, null);
		TreeNode node14 = new TreeNode(14, null, null);
		TreeNode node15 = new TreeNode(15, null, null);
		
		root.setLeftNode(node2);
		root.setRightNode(node3);
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		node3.setLeftNode(node6);
		node3.setRightNode(node7);
		node4.setLeftNode(node8);
		node4.setRightNode(node9);
		node5.setLeftNode(node12);
		node7.setLeftNode(node10);
		node9.setLeftNode(node13);
		node9.setRightNode(node14);
		node10.setRightNode(node11);
		node14.setLeftNode(node15);
		
		PrintPostOrder(root);
		System.out.println();
		PruneTree(root,0);
	}
	
	/**
	 * @param root
	 */
	public static void PrintPostOrder(TreeNode node){
		if(node.getLeftNode()!= null){
			PrintPostOrder(node.getLeftNode());
		}
		if(node.getRightNode() != null){
			PrintPostOrder(node.getRightNode());
		}
		System.out.print(node.getData()+" ");

	}
	
	/**
	 * 
	 * @param node
	 * @param sum
	 * @param min
	 */
	public static int PruneTree(TreeNode node, int sum){
		sum = sum+ node.getData();
		if(node.getLeftNode() != null && node.getRightNode()!=null)
		{
			if(Math.max(PruneTree(node.getLeftNode(),sum), PruneTree(node.getRightNode(),sum))< min){
				//delete the node
				System.out.print(node.getLeftNode().getData()+" ");
				System.out.print(node.getRightNode().getData()+" ");
			}
		}
		else if(node.getLeftNode() != null)
		{
			if(PruneTree(node.getLeftNode(),sum) < min){
				System.out.print(node.getLeftNode().getData()+" ");
			}
		}
		else if(node.getRightNode() != null)
		{
			if(PruneTree(node.getRightNode(),sum) < min){
				System.out.print(node.getRightNode().getData()+" ");
			}
		}
		return sum;
	}
}
