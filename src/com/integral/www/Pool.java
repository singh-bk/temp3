package com.integral.www;

public interface Pool<T> {

    T get();
    
    void release(T t);
    
}
