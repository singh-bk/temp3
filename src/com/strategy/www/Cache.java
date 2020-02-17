package com.strategy.www;

public interface Cache<K, V> {

    public V get(K k);

    public boolean put(K k, V v, long expireInMs);


}
