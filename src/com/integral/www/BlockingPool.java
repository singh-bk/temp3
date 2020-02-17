package com.integral.www;

import java.util.concurrent.TimeUnit;

public interface BlockingPool<T> extends Pool<T> {
    
    @Override
    T get();

    @Override
    void release(T t);
    
    T get(long time, TimeUnit unit);
}
