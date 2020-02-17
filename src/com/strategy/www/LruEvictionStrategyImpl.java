package com.strategy.www;

import java.util.LinkedList;

public class LruEvictionStrategyImpl<K> implements EvictionStrategy<K> {

    LinkedList<K> list;
    int size;
    
    public LruEvictionStrategyImpl(int s) {
        size = s;
        list = new LinkedList<>();
    }
    
    @Override
    public boolean remove(K k) {
        list.removeLast();
        return true;
    }

    @Override
    public void init() {
        
    }

    @Override
    public void add(K k) {
       list.addFirst(k);
    }
    
    @Override
    public K getEvictedElem() {
        return list.getLast();
    }

    @Override
    public void update(K k) {
        list.remove(k);
        //lock
        final K kk = list.getFirst();
        
        list.addFirst(k);
    }
    

}
