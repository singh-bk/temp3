package com.trie.www;

import java.util.ArrayList;
import java.util.Hashtable;

public class Trie {
	
	TrieNode root;
	public Trie(){
		this.root = new TrieNode((char)0);
	}
	
	/**
	 * Insert the string into the trie.
	 * @param word
	 */
	public void insert(String word)
	{
		TrieNode node = this.root;
		//TrieNode parent = this.root;
		Hashtable<Character, TrieNode> children = node.getChildren();
		char[] chars = word.toCharArray();
		boolean found = false;
		TrieNode child = null;
		/*
		 * For every char, check if its present in children
		 *  	1. If no, add a new child to the parent
		 *  	2. if yes, then update the parent to the child found
		 *  		update the list of children as well.
		 *  go the next char 
		 */
		for(int i=0;i<chars.length;i++)
		{
			if(children.get(chars[i]) != null)
			{
				found = true;
				child = children.get(chars[i]);
				children = child.getChildren();
			}
			else
			{
				child = new TrieNode(chars[i]);
				children.put(chars[i], child);
				children = child.getChildren();
			}
		}
		child.setEnd(true);
	}
	
	/**
	 * @param word
	 * @return boolean
	 */
	public boolean find(String word)
	{
		boolean found = false;
		char[] chars = word.toCharArray();
		TrieNode node = this.root;
		//TrieNode parent = this.root;
		Hashtable<Character, TrieNode> children = node.getChildren();
		TrieNode child = null;
		
		for(int i=0;i<chars.length;i++)
		{
			if(children.get(chars[i]) != null)
			{
				found = true;
				child = children.get(chars[i]);
				children = child.getChildren();
			}
			else
			{
				found = false;
				break;
			}
		}
		if((child!=null && child.isEnd()==true) || children.size() == 0)
			return found;
		else
			return false;
	}
	
	/**
	 * Find a word and delete it
	 * @param word
	 * @return
	 */
	public void delete(String word)
	{
		char[] chars = word.toCharArray();
		TrieNode node = this.root;
		Hashtable<Character, TrieNode> children = node.getChildren();
		ArrayList<TrieNode> deleteList = new ArrayList<TrieNode>();
		
		node = children.get(chars[0]);
		if(node != null)
		{
			deleteList.add(node);
			children = node.getChildren();
		}
		else
		{
			return;
		}
		for(int i=1; i<chars.length;i++)
		{
			node = children.get(chars[i]);
			if(node != null)
			{
				if(children.size() > 1)
				{
					deleteList = new ArrayList<TrieNode>();
				}
				deleteList.add(node);
				children = node.getChildren();
			}
		}
		
		if(children.size() > 0){
			deleteList = null;
		}
		if(deleteList != null){
			System.out.println("Delete Elements:"+deleteList.size());
			for(int i=0;i<deleteList.size();i++)
				System.out.print(deleteList.get(i).getData()+" ");
		}
	}
}
