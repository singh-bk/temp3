package com.uber.www;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cache2 {

	private Map<String, String> map;
	private ConcurrentLinkedDeque<String> list;
	private int max_size;

	public Cache2(final int len) {
		this.list = new ConcurrentLinkedDeque<String>();
		this.map = new ConcurrentHashMap<String, String>();
		this.max_size = len;
	}

	public String getValue(String name) {
		return map.get(name);
	}

	public int size() {
		return this.map.size();
	}

	public void add(String name, String value) {
		map.put(name, value);
		list.addFirst(name);
		if (this.exceedsSize()) {
			this.remove();
		}
	}

	public void remove() {
		String last = this.list.removeLast();
		this.remove(last);
	}

	public void remove(String name) {
		map.remove(name);
	}

	public boolean exceedsSize() {
		return (this.list.size() > this.max_size);
	}

}
