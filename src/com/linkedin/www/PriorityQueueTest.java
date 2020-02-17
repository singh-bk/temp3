package com.linkedin.www;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        final PriorityQueue<N> queue = new PriorityQueue<N>(5, new Comparator<N>() {
            
            @Override
            public int compare(N n1, N n2) {
                return n1.value - n2.value;
            }
        });
        
       final N n1 = new N(1, 1);
       final N n2 = new N(2, 2);
       final N n0 = new N(0, 0);
       final N n3 = new N(3, 3);
       final N n4 = new N(4, 4);
       final N n5 = new N(5, 5);
       final N n6 = new N(6, 6);
       final N n7 = new N(7, 7);
       queue.add(n1);
       queue.add(n2);
       queue.add(n0);
       queue.add(n3);
       queue.add(n4);
       queue.add(n5);
       queue.add(n6);
       queue.add(n7);
       
       System.out.println(queue.peek().value);
       
    }
    
    
}
class N{
    int key;
    int value;
    
    N(int kk, int vv){
        key = kk;
        value = vv;
    }
}