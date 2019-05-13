package com.concurrent.www;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import com.snapdeal.www.LruNode;

public class ThreadSafeLruCacheImpl2 {

	private static final int MAX_CAPACITY = 10000;
	private ConcurrentHashMap<String, LruNode> map = new ConcurrentHashMap<String, LruNode>(
			MAX_CAPACITY);
	
	private LruNode head;
	private LruNode tail;

	public ThreadSafeLruCacheImpl2() {
		// TODO Auto-generated constructor stub
	}

	public LruNode get(String domain) {
		LruNode value = map.get(domain);
		if (value != null) {
			LruNode prev = value.getPrev();
			LruNode next = value.getNext();
			if (next != null) {
				// move the node to the tail from the its current position
				if(prev == null){
					//if the current is head - update the head
					AtomicReference<LruNode> atomicHead = new AtomicReference<LruNode>(head);
					boolean updated = atomicHead.compareAndSet(head, head.getNext());
					if(updated){
						head = atomicHead.get();
					}
				} 
				AtomicReference<LruNode> atomicTail = new AtomicReference<LruNode>(
						tail);
				AtomicReference<LruNode> atomicPrev = new AtomicReference<LruNode>(
						prev);
				LruNode updatedTail = tail;
				updatedTail.setNext(value);
				boolean updated = atomicTail.compareAndSet(tail, updatedTail);
				if (updated) {
					LruNode updatedPrev = prev;
					updatedPrev.setNext(next);
					updated = atomicPrev.compareAndSet(prev, updatedPrev);
					if (updated) {
						tail = atomicTail.get();
						atomicTail.compareAndSet(tail, value);
						tail = atomicTail.get();
					}
				}
			}
			
			return value;
		} else {
			LruNode node = load(domain);
			put(node);
		}

		// TODO Auto-generated method stub
		return value;
	}

	public LruNode load(String domain) {
		LruNode node = new LruNode(domain, null, null);
		return node;
	}

	public LruNode put(LruNode node) {
		LruNode value = map.putIfAbsent(node.getDomain(), node);
		if (value == null) {
			// add node to the tail of the list
			AtomicReference<LruNode> atomicTail = new AtomicReference<LruNode>(tail);
			if(tail == null){
				atomicTail.compareAndSet(tail, value);
			}else{
				LruNode updatedTail = tail;
				updatedTail.setNext(value);
				while(atomicTail.compareAndSet(tail, updatedTail));
				tail = value;
			}
			return node;
		} else {
			//return the value that was found
			return value;
		}
	}

	public boolean offer(LruNode node) {
		if (!tail.getDomain().equals(node.getDomain())) {

		}
		return false;
	}

	public boolean evict() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}

}
