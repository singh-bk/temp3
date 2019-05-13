package com.heap.www;

/**
 * 
 * @author singhbir
 *
 */
public class HeapNode {

	private String word;
	private int count;
	
	/**
	 * @param word
	 */
	public HeapNode(String word){
		this.word = word;
		this.count = this.getCount()+1;
	}
	
	public HeapNode(String word, int count){
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
