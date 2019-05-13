package com.thread2.www;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
 
private BlockingQueue<Integer> queue;
     
    public Consumer(BlockingQueue<Integer> q){
        this.queue=q;
    }
 
    @Override
    public void run() {
        try{
        	int num;
            //consuming messages until exit message is received
            while(true){
            Thread.sleep(10);
            num = queue.take();
            System.out.println("Consumed "+num);
            if(num == 99)
            	break;
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}