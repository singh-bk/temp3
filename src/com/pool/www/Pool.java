package com.pool.www;

public interface Pool<T> {

    T get();
    
    void release(T t);
}
