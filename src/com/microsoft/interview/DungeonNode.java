package com.microsoft.interview;

public class DungeonNode {

	private int data;
	private int x;
	private int y;
	
	public DungeonNode(int data, int x, int y){
		this.data = data;
		this.x = x;
		this.y = y;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
