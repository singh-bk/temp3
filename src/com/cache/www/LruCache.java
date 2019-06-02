package com.cache.www;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

	Map<K, Node<K, V>> map = new HashMap<K, Node<K, V>>();
	Node<K, V> head = null;
	Node<K, V> tail = null;
	int size;
	int MAX_SIZE;

	public LruCache(int maxSize) {
		MAX_SIZE = maxSize;
	}

	public V get(K key) {
		Node<K, V> node = map.get(key);
		node.prev.next = node.next;
		
		
		Node<K, V> oldHead = head;
		head = node;
		head.prev = null;
		head.next = oldHead;
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

class Node<K, V> {
	K k;
	V v;
	Node<K, V> next;
	Node<K, V> prev;

	Node(K k, V v) {
		this.k = k;
		this.v = v;
	}
}
