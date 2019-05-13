package com.trie.www;

public class TrieTest {

	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("tree");
		trie.insert("trie");
		trie.insert("all");
		trie.insert("alll");
		trie.insert("also");
		trie.insert("algo");
		trie.insert("assoc");
		System.out.println("al "+trie.find("al"));
		System.out.println("all "+trie.find("all"));
		//System.out.println("alg "+trie.find("alg"));
		//System.out.println("algo "+trie.find("algo"));
		//System.out.println("treee "+trie.find("treee"));
		//System.out.println("tree "+trie.find("tree"));
		trie.delete("als");
	}
}
