package com.concurrent.www;

import java.util.concurrent.ConcurrentHashMap;

import com.snapdeal.www.LruNode;

public class ThreadSafeLruCacheImpl implements ThreadSafeLruCache{

	private static final int MAX_CAPACITY = 10000;
	private ConcurrentHashMap<String, LruNode> map = new ConcurrentHashMap<String, LruNode>(MAX_CAPACITY);
	private LruNode head;
	private LruNode tail;
	
	public ThreadSafeLruCacheImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LruNode get(String domain) {
		LruNode value = map.get(domain);
		if(value != null){
			//invoke offer
			//invoke purge
			return value;
		}else{
			//invoke load
			//invoke put
		}
		
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public LruNode load(String domain) {
		LruNode node = new LruNode(domain, null, null);
		return node;
	}

	@Override
	public LruNode put(LruNode node) {
		LruNode value = map.putIfAbsent(node.getDomain(), node);
		if(value == null){
			// invoke offer
			// check evict and invoke evict if true
			return node;
		}else{
			return value;
		}
	}

	@Override
	public boolean offer(LruNode node) {
		if(!tail.getDomain().equals(node.getDomain())){
			
		}
		return false;
	}

	@Override
	public boolean evict() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}

}
