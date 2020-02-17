package com.leetcode.twilio;

public class LRUCacheTest {

    public static void main33(String[] args) {
        final LRUCache2 cache = new LRUCache2(10);
        cache.put(7, 28);
        cache.put(7, 1);
        cache.put(8, 15);
        System.out.println(cache.get(6));
        cache.put(10,27);
        cache.put(8,10);
        System.out.println(cache.get(8));
        cache.put(6,29);
        cache.put(1,9);
        System.out.println(cache.get(6));
        cache.put(10,7);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(13));
        cache.put(8,30);
        cache.put(1, 5);
        System.out.println(cache.get(1));
        cache.put(13,2);
        System.out.println(cache.get(13));
    }
    
    
    public static void main(String[] args) {
        final LRUCache2 cache = new LRUCache2(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
    
    public static void main2(String[] args) {
        final LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3); 
        System.out.println(cache.get(2));
        cache.put(4, 4); 
        System.out.println(cache.get(1)); 
        System.out.println(cache.get(3)); 
        System.out.println(cache.get(4)); 
    }
    
    /*
    public static void main(String[] args) {
        final LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3); 
        System.out.println(cache.get(2)); 
        cache.put(4, 4);
        System.out.println(cache.get(1)); 
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    */
}
