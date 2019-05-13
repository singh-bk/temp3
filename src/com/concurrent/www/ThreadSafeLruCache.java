package com.concurrent.www;

import com.snapdeal.www.LruNode;

public interface ThreadSafeLruCache {

	public LruNode get(String domain);
	
	public LruNode load(String domain);
	
	public LruNode put(LruNode node);
	
	public boolean offer(LruNode node);
	
	public boolean evict();
	
	public boolean purge();
}
