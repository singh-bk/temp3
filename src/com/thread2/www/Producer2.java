package com.thread2.www;

import java.util.concurrent.BlockingQueue;

public class Producer2 implements Runnable{

	 
    private BlockingQueue<Integer> queue;
     
    public Producer2(BlockingQueue<Integer> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=2; i<100; i=i+2){
            try {
                Thread.sleep(i);
                queue.put(i);
                //System.out.println("Produced "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 

}
