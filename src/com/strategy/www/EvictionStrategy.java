package com.strategy.www;

public interface EvictionStrategy<K> {
    
    public void init();
    
    public boolean remove(K k);
    
    public void add(K k);
    
    public K getEvictedElem();
    
    public void update(K k);

}
