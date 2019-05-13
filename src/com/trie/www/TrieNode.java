package com.trie.www;

import java.util.Hashtable;

public class TrieNode {

	private char data;
	private Hashtable<Character, TrieNode> children;
	private boolean isEnd;
	
	public TrieNode(char ch)
	{
		this.data = ch;
		this.children = new Hashtable<Character, TrieNode>();
		this.isEnd = false;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public char getData() {
		return data;
	}

	public Hashtable<Character, TrieNode> getChildren() {
		return children;
	}
}
