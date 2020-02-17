package com.strategy.www;

import java.util.PriorityQueue;

public class RankEvictionStrategyImpl<K> implements EvictionStrategy<K> {

    PriorityQueue<K> queue;
    
    public RankEvictionStrategyImpl(int size) {
        queue = new PriorityQueue<>(size);
    }
    
    @Override
    public boolean remove(K k) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(K k) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public K getEvictedElem() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(K k) {
        // TODO Auto-generated method stub
        
    }

}
