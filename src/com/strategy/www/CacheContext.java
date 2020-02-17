package com.strategy.www;

public class CacheContext<K, V> {

    Cache<K, V> cache;

    public CacheContext(int size, EvictionPolicy ep) {

        switch (ep) {
            case BEST_RANK_EVICTION:
                cache = new CacheImpl<>(size, new RankEvictionStrategyImpl<>(size));
                break;
            case LRU_EVICTION:
                cache = new CacheImpl<>(size, new LruEvictionStrategyImpl<>(size));
                break;
        }
    }
    
    
}
