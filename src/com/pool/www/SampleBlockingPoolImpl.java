package com.pool.www;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SampleBlockingPoolImpl implements BlockingPool<Sample>{

    BlockingQueue<Sample> objects;
    int size;
    
    public SampleBlockingPoolImpl(int size) {
        this.size = size;
        objects = new LinkedBlockingQueue<Sample>();
        initializeObjects();
    }
    
    @Override
    public Sample get() {
        return objects.poll();
    }

    @Override
    public void release(Sample t) {
        objects.offer(t);
    }

    @Override
    public Sample get(long timeout, TimeUnit unit) {
        try {
            return objects.poll(timeout, unit);
        }
        catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    private void initializeObjects() {
        for(int i=0;i<size;i++) {
            objects.add(SampleFactory.create());
        }
    }
    
}
