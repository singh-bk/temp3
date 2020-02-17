package com.hp.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

	private TreeNode root;
	
	public TreeNode getRoot()
	{
		return root;
	}
	public void insert(int data)
	{
		//if root is null, add root
		if(root == null)
		{
			root = new TreeNode(data,null,null);
		}
		else if(data>root.getData())
		{
			insertRight(root, data);
		}
		else if(data<root.getData())
		{
			insertLeft(root, data);
		}
	}
	
	public void insertRight(TreeNode node, int data)
	{
		final TreeNode right = node.getRightNode();
		if(right == null)
		{
			node.setRightNode(new TreeNode(data,null,null));
		}
		else if(data == right.getData())
		{
			System.out.println("The node is already present");
		}
		else if(data > right.getData())
		{
			insertRight(right, data);
		}
		else if(data < right.getData())
		{
			insertLeft(right, data);
		}
	}
	
	public void insertLeft(TreeNode node, int data)
	{
		final TreeNode left = node.getLeftNode();
		if(left == null)
		{
			node.setLeftNode(new TreeNode(data,null,null));
		}
		else if(data > left.getData())
		{
			insertRight(left, data);
		}
		else if(data < left.getData())
		{
			insertLeft(left, data);
		}
	}
	
	public void preorderDisplay(TreeNode node)
	{
		if(node!=null)
		{
			System.out.print(node.getData()+" ");
			preorderDisplay(node.getLeftNode());
			preorderDisplay(node.getRightNode());
		}
	}
	
	public void inorderDisplay(TreeNode node)
	{
		if(node!=null)
		{
			inorderDisplay(node.getLeftNode());
			System.out.print(node.getData()+" ");
			inorderDisplay(node.getRightNode());
		}
	}	
	public void postOrderDisplay(TreeNode node)
	{
		if(node!=null)
		{
			postOrderDisplay(node.getLeftNode());
			postOrderDisplay(node.getRightNode());
			System.out.print(node.getData()+" ");
		}
	}

	/**
	 * Method to get the parent/ancestor
	 * @param value
	 * @return
	 */
	
	public void searchAndPrintParent(int value) {
	    
	}
	
	public List<TreeNode> getAncestors(int value)
	{
		final List<TreeNode> ancestors = new LinkedList<TreeNode>();
		if(value==this.root.getData())
		{
			System.out.println("This is a root");
		}
		else if(value < root.getData())
		{
			TreeNode node2 = root;
			ancestors.add(node2);
			TreeNode node3 = node2.getLeftNode();
			while(node3 != null)
			{
				if(node3.getData() == value)
				{
					break;
				}
				else if(node3.getData() > value)
				{
					ancestors.add(node3);
					node2 = node3;
					node3 = node3.getLeftNode();
				}
				else if(node3.getData() < value)
				{
					ancestors.add(node3);
					node2 = node3;
					node3 = node3.getRightNode();
				}
			}
		}
		else if(value > root.getData())
		{
			TreeNode node2 = root;
			ancestors.add(node2);
			TreeNode node3 = node2.getRightNode();
			while(node3 != null)
			{
				if(node3.getData() == value)
				{
					break;
				}
				else if(node3.getData() > value)
				{
					ancestors.add(node3);
					node2 = node3;
					node3 = node3.getLeftNode();
				}
				else if(node3.getData() < value)
				{
					ancestors.add(node3);
					node2 = node3;
					node3 = node3.getRightNode();
				}
			}
		}
		return ancestors;
	}	
	
	/**
	 * @param parent
	 * @param node
	 * @param val
	 */
	public void deleteNode(TreeNode parent, TreeNode node, int val)
	{
		if(node.getData() > val)
		{
			deleteNode(node, node.getLeftNode(), val);
		}
		else if(node.getData() < val)
		{
			deleteNode(node, node.getRightNode(), val);
		}
		//The node to be deleted has been found.
		else if(node.getData() == val)
		{
			/*
			 * 1. If Node has no child left, delete the node.
			 * 2. Else If node has just one child node(either left or right) - replace the node, with the child node
			 * 3. Else if the node has both the children
			 * 		a. Find the max from the left child
			 * 		b. replace the value obtained from 
			 */
			if(node.getLeftNode() == null && node.getRightNode() == null)
			{
				if(parent.getLeftNode().equals(node))
				{
					parent.setLeftNode(null);
				}
				else if(parent.getRightNode().equals(node))
				{
					parent.setRightNode(null);
				}
			}
			else if(node.getLeftNode() != null && node.getRightNode() == null)
			{
				final TreeNode child = node.getLeftNode();
				if(parent.getLeftNode().equals(node))
				{
					parent.setLeftNode(child);
				}
				else if(parent.getRightNode().equals(node))
				{
					parent.setRightNode(child);
				}
			}
			else if(node.getLeftNode() == null && node.getRightNode() != null)
			{
				final TreeNode child = node.getRightNode();
				if(parent.getLeftNode().equals(node))
				{
					parent.setLeftNode(child);
				}
				else if(parent.getRightNode().equals(node))
				{
					parent.setRightNode(child);
				}
			}
			// node is the Node to be deleted
			else if(node.getLeftNode() != null && node.getRightNode() != null)
			{
				//get the left child
				TreeNode child = node.getLeftNode();
				TreeNode parent2 = node;
				//get the max from the left side of the node
				while(child.getRightNode() != null)
				{
					parent2 = child;
					child = child.getRightNode();
				}
				/*
				 * child at this stage is the max value from the left hand side of node
				 * the value of child needs to be put in the node.
				 * pointer to child should be deleted
				 */
				if(parent.getLeftNode().equals(node))
				{
					parent.getLeftNode().setData(child.getData());
					parent2.setRightNode(null);
					//child = null;
				}
				else if(parent.getRightNode().equals(node))
				{
					parent.getRightNode().setData(child.getData());
					parent2.setRightNode(null);
					//child = null;
				}
			}
		}
	}
}
