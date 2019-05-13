package com.saplabs.www;

public class BinarySearchTree {

	private BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	public BinarySearchTree(BinaryNode root){
		this.root = root;
	}
	
	/**
	 * Insert a BinaryNode into the BST.
	 * 
	 * @param node
	 */
	public void insert(BinaryNode target, BinaryNode node){
		if(target == null){
			target = node;
			return;
		}
		else if(target.getData() == node.getData())
		{
			System.out.println("The node is already present");
			return;
		}
		else if(target.getData() < node.getData())
		{
			if(target.getRight() != null){
				insert(target.getRight(), node);
			}
			else{
				target.setRight(node);
				return;
			}
		}
		else
		{
			if(target.getLeft() != null){
				insert(target.getLeft(), node);
			}
			else{
				target.setLeft(node);
				return;
			}
		}
	}
	
	/**
	 * Remove a node from BST
	 * 
	 * Start from the root(node) of the tree
	 * 		if value of node is greater than input
	 * 			
	 * @param node
	 */
	public void remove(BinaryNode input){
		BinaryNode node = this.root;
		BinaryNode parent = null;
		boolean isFound = false;
		boolean leftNode = false;
		boolean rightNode = false;
		while(node != null){
			if(node.getData() == input.getData()){
				isFound = true;
				break;
			}
			else if(node.getData() > input.getData()){
				parent = node;
				leftNode = true;
				rightNode = false;
				node = node.getLeft();
			}
			else if(node.getData() < input.getData()){
				parent = node;
				leftNode = false;
				rightNode = true;
				node = node.getRight();
			}
		}
		
		/*
		 * Check 
		 */
		if(isFound){
			if(node.getLeft() == null && node.getRight() == null){
				if(leftNode){
					parent.setLeft(null);
				}else if(rightNode){
					parent.setRight(node);
				}
			}
			else{
				/*
				 *find the min from the right 
				 */
				if(node.getRight() != null){
					BinaryNode temp = node.getRight();
					while(temp.getLeft() != null){
						
					}
				}
				else if(node.getLeft() != null){
					
				}
			}
		}
	}
}
