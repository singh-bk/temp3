package com.leetcode.twilio;

import java.util.LinkedHashMap;

public class LRUCache2 extends LinkedHashMap<Integer, Integer>{

    private final int MAX_SIZE;
    public LRUCache2(int capacity) {
        super(capacity, .75f, true);
        this.MAX_SIZE = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > MAX_SIZE;
    }
}
