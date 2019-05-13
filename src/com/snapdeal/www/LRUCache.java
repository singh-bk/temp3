package com.snapdeal.www;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

	private ConcurrentHashMap<String, LruNode> map;
	
	private LruNode head;
	private LruNode tail;
	
	public LRUCache(){
		map =  new ConcurrentHashMap<String, LruNode>();
	}
	
	public LruNode cacheLookup(String domain){
		LruNode node = map.get(domain);
		return node;
	}
	
	/**
	 * This should always add the new domain as the first element of the list
	 * @param domain
	 * @return
	 */
	public boolean addToCache(String domain){
		LruNode node = new LruNode(domain, null, null);
		boolean added = false;
		if(head == null){
			head = node;
			added = true;
		}else{
			node.setNext(head);
			head.setPrev(node);
			head = node;
			added = true;
		}
		map.put(domain, node);
		return added;
	}
	
	/**
	 * Move the node to the front of the cache
	 * @param node
	 * @return
	 */
	public boolean updateCache(LruNode node){
		head.setPrev(node);
		node.setNext(head);
		head = node;
		return head;
	}
}
