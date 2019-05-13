package com.thread2.www;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
 
public class ProducerConsumerService {
 
    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
        Producer producer = new Producer(queue);
        Producer2 producer2 = new Producer2(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        new Thread(producer2).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
 
}