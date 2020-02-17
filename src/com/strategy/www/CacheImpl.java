package com.strategy.www;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheImpl<K, V> implements Cache<K, V> {

    int size;
    Map<K, V> map;
    EvictionStrategy<K> evictionStrategy;
    
    public CacheImpl(int s, EvictionStrategy<K> es) {
        size = s;
        map = new ConcurrentHashMap<>();
        evictionStrategy = es;
    }
    
    @Override
    public V get(K k) {
        V value = null;
        if(map.get(k) != null) {
            value = map.get(k);
            evictionStrategy.update(k);
        }
        return value;
    }

    @Override
    public boolean put(K k, V v, long expireInMs) {
        
        if(map.size() == size) {
            final K k1 = evictionStrategy.getEvictedElem();
            map.remove(k1);
            evictionStrategy.remove(k1);
        }
        map.put(k, v);
        evictionStrategy.add(k);
        return true;
    }

}
