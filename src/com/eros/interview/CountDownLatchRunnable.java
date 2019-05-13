package com.eros.interview;

import java.util.concurrent.CountDownLatch;

class CountDownLatchRunnable implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
  
    public CountDownLatchRunnable(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }
  
    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
        	System.out.println("Interrupted Exception in CountDownLatchRunnable.run()");
        }
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
  
}

