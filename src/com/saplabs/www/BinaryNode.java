package com.saplabs.www;

public class BinaryNode implements Comparable<BinaryNode>{

	private int data;
	private BinaryNode left;
	private BinaryNode right;
	
	public BinaryNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	@Override
	public int compareTo(BinaryNode node) {
		if(this.getData() == node.getData())
			return 0;
		else if(this.getData() > node.getData())
			return 1;
		else
			return -1;
	}
}
