package com.cache.www;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadSafeLruCache<K, V> {

	Map<K, Node<K, V>> map = new ConcurrentHashMap<K, Node<K, V>>();
	AtomicReference<Node<K, V>> atomicHead = new AtomicReference<Node<K, V>>();
	AtomicReference<Node<K, V>> atomicTail = new AtomicReference<Node<K, V>>();
	AtomicInteger size;
	int MAX_SIZE;

	public ThreadSafeLruCache(int maxSize) {
		MAX_SIZE = maxSize;
		size = new AtomicInteger(0);
	}

	public V get(K key) {
		Node<K, V> node = map.get(key);
		node.prev.next = node.next;
		node.prev = null;
		
		Node<K, V> oldHead = atomicHead.get();
		node.next = oldHead;
		while(!atomicHead.compareAndSet(atomicHead.get(), node)){
			oldHead = atomicHead.get();
			node.next = oldHead;
		}
		return node.v;
	}

	public void put(K key, V value) {
		Node<K, V> node = new Node<K, V>(key, value);
		map.put(key, node);
		
		if (atomicHead.get() == null) {
			atomicHead.compareAndSet(null, node);
			atomicTail.compareAndSet(null, node);
		} else {
			Node<K, V> oldHead = atomicHead.get();
			node.next = oldHead;
			oldHead.prev = atomicHead.get();
			while(!atomicHead.compareAndSet(atomicHead.get(), node)){
				oldHead = atomicHead.get();
				node.next = oldHead;
				oldHead.prev = atomicHead.get();
			}
		}
		size.incrementAndGet();
		while (size.get() > MAX_SIZE) {
			Node<K, V> prev = atomicTail.get().prev;
			prev.next = null;
			size.decrementAndGet();
			atomicTail.compareAndSet(atomicTail.get(), prev);
		}
	}
	
	public void print(){
		map.forEach((k, v) -> System.out.println("key:"+k+" value:"+v.v));
	}

}
