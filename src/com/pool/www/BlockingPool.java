package com.pool.www;

import java.util.concurrent.TimeUnit;

public interface BlockingPool<T> extends Pool<T>{

    T get(long timeout, TimeUnit unit);
}
