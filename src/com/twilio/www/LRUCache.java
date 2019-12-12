package com.twilio.www;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head;
    Node tail;
    int len;
    int MAX_LEN;
    
    public LRUCache(int capacity) {
        MAX_LEN = capacity;
    }
    
    public int get(int key) {
        final Node val = map.get(key);
        if(val != null ) {
            if(val.prev != null) {
                val.prev.next = val.next;
            }
            if(val.next != null) {
                val.next.prev = val.prev;
            }else {
                tail = val.prev;
            }
            val.next = head;
            val.prev = null;
            head.prev = val;
            head = val;
            return val.val;
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node val = map.get(key);
        if(val != null) {
            val.val = value;
            val.prev.next = val.next;
            if(val.next != null) {
                val.next.prev = val.prev;
            }else {
                tail = val.prev;
            }
            val.next = head;
            val.prev = null;
            head.prev = val;
            head = val;
        }else {
            val = new Node();
            val.key = key;
            val.val = value;
            val.next = head;
            val.prev = null;
            if(head != null) {
                head.prev = val;
            }
            head = val;
            if(tail == null) {
                tail = head;
            }
            map.put(key, val);
            len++;
            if(len > MAX_LEN) {
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                len--;
            }
        }
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}
