package com.integral.www;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.groupon.www.ObjectFactory;

public class BlockingPoolImpl<T> implements BlockingPool<T> {

    int size;
    private final BlockingQueue<T> objects;
    
    BlockingPoolImpl(int size){
        this.size = size;
        this.objects = new LinkedBlockingQueue<T>(size);
        initializeObjects();
    }
    
    @Override
    public T get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void release(T t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T get(long time, TimeUnit unit) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private void initializeObjects() {
        for(int i=0;i<size;i++) {
            final T t = ObjectFactory<T>
            
        }
    }

}
