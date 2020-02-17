package com.cache2.www;

public interface LruCache<K, V> {

    public V get(K k);
}
