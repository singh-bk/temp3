package com.saplabs.www;

public class SnakeLadderNode {

	private boolean isSnakeBite;
	private boolean isLadderTail;
	private int snakeTail;
	private int ladderHead;
	
	
	public SnakeLadderNode(boolean isSnakeBite,boolean isLadderTail){
		this.isSnakeBite = isSnakeBite;
		this.isLadderTail = isLadderTail;
	}
	
	public SnakeLadderNode(boolean isSnakeBite,boolean isLadderTail,int snakeTail, int ladderHead){
		this.isSnakeBite = isSnakeBite;
		this.isLadderTail = isLadderTail;
		if(isSnakeBite)
			this.snakeTail = snakeTail;
		if(isLadderTail)
			this.ladderHead = ladderHead;
	}
	
	public boolean isSnakeBite() {
		return isSnakeBite;
	}
	public void setSnakeBite(boolean isSnakeBite) {
		this.isSnakeBite = isSnakeBite;
	}
	public boolean isLadderTail() {
		return isLadderTail;
	}
	public void setLadderTail(boolean isLadderTail) {
		this.isLadderTail = isLadderTail;
	}
	
	public int getSnakeTail(){
		if(this.isSnakeBite == true){
			return this.snakeTail;
		}
		else
			return -1;
	}
	
	public int getLadderHead(){
		if(this.isLadderTail == true){
			return this.ladderHead;
		}
		else
			return -1;
	}
}
