package com.cache.www;

public class LruCacheTest {

	public static void main(String[] args) {
		LruCache<Integer, Integer> cache = new LruCache<Integer, Integer>(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(1, 4);
		cache.print();
		
		ThreadSafeLruCache<Integer, Integer> cache2 = new ThreadSafeLruCache<Integer, Integer>(3);
		cache2.put(1, 1);
		cache2.put(2, 2);
		cache2.put(3, 3);
		cache2.put(1, 4);
		cache2.print();
	
		ThreadSafeLruCache2<Integer, Integer> cache3 = new ThreadSafeLruCache2<Integer, Integer>(3);
		cache3.put(1, 1);
		cache3.put(2, 2);
		cache3.put(3, 3);
		cache3.put(1, 4);
		cache3.print();
	}
}
