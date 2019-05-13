package com.hp.binarytree;

public class TreeNode {

	private TreeNode left;
	private TreeNode right;
	private int value;
	private TreeNode neighbor;
	private boolean visited;
	
	public TreeNode(int value, TreeNode left, TreeNode right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getData()
	{
		return this.value; 
	}
	
	public void setData(int value)
	{
		this.value = value;
	}
	
	public TreeNode getLeftNode()
	{
		return this.left;
	}
	
	public void setLeftNode(TreeNode left)
	{
		this.left = left;
	}
	
	public TreeNode getRightNode()
	{
		return this.right;
	}
	
	public void setRightNode(TreeNode right)
	{
		this.right = right;
	}

	public TreeNode getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(TreeNode neighbor) {
		this.neighbor = neighbor;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
