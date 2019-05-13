package com.hp.binarytree;

public class BinaryTree {

	private TreeNode root;
	public TreeNode getRoot()
	{
		return root;
	}
	
	public void addRoot(int data)
	{
		root = new TreeNode(data, null, null);
	}
	
	public void addNode(int data)
	{
		if(root == null)
		{
			addRoot(data);
		}
		else
		{
			//TreeNode node = new TreeNode(data,null,null);
			addNode(root, data);
		}
	}
	
	public void addNode(TreeNode node, int data)
	{
		TreeNode node1 = new TreeNode(data,null,null);
		if(node.getLeftNode() == null)
		{
			node.setLeftNode(node1);
		}
		else if(node1.getRightNode() == null)
		{
			node.setRightNode(node1);
		}
		else
		{
			
		}
	}
	
}
