package com.harness.www;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class StreamTest {

    public static void main(String[] args) {
        final PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(20);
        queue.offer(70);
        queue.offer(10);
        queue.offer(30);
        queue.offer(60);
        queue.offer(15);
        queue.offer(12);
        queue.offer(11);
        queue.offer(9);
        final Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        while(!queue.isEmpty()) {
            
            System.out.println(queue.poll());
        }
        final PriorityQueue<Node> queue2 = new PriorityQueue<Node>((o1, o2)-> o1.key - o2.key );
    }
    
    class Node implements Comparator<Node>{
        int key;
        int val;
        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
            //return 0;
        }
        
    }
    
  
}
