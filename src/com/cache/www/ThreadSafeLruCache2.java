package com.cache.www;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLruCache2<K, V> {

	Map<K, Node<K, V>> map = new ConcurrentHashMap<K, Node<K, V>>();
	Node<K, V> head = null;
	Node<K, V> tail = null;
	ReadWriteLock lock = new ReentrantReadWriteLock();
	int size;
	int MAX_SIZE;

	public ThreadSafeLruCache2(int maxSize) {
		MAX_SIZE = maxSize;
	}

	public V get(K key) {
		Node<K, V> node = null;
		try{
			lock.readLock().lock();
			node = map.get(key);
			if(node != null){
				lock.writeLock().lock();
				node.prev.next = node.next;
				Node<K, V> oldHead = head;
				head = node;
				head.prev = null;
				head.next = oldHead;
			}else{
				return null;
			}
		}finally{
			lock.writeLock().unlock();
			lock.readLock().unlock();
		}
		return node.v;
	}

	public void put(K key, V value) {
		Node<K, V> node = new Node<K, V>(key, value);
		map.put(key, node);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node<K, V> oldHead = head;
			head = node;
			head.next = oldHead;
			oldHead.prev = head;
		}
		size++;
		if (size > MAX_SIZE) {
			Node<K, V> prev = tail.prev;
			prev.next = null;
			size--;
			tail = prev;
		}
	}
	
	public void print(){
		map.forEach((k, v) -> System.out.println("key:"+k+" value:"+v.v));
	}

}
