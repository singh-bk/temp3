package com.confluent.www;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;



class WindowProcessorImpl implements WindowProcessor{

    Map<String, Node> map = new ConcurrentHashMap<String, Node>();
    // List<Node> list = new LinkedList<Node>();
    double currentAvg;
    AtomicReference<Node> atomicHead = new AtomicReference<Node>();
    AtomicReference<Node> atomicTail = new AtomicReference<Node>();
    Node head;
    Node tail;
    int currentSize;
    int windowSize;
  
    public WindowProcessorImpl(int windowSize){
      this.windowSize = windowSize;
    }
  
    @Override
    public void put(String key, int value){
      Node node = map.get(key);
      
      if(node != null){
        node.ttl = Instant.now() + windowSize;
        node.value = value;
        map.put(key, node);
        node.prev.next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
        
      }
      else{
        node = new Node(key, value, Instant.now() + windowSize);
        map.put(key, node);
        if(head == null){
          head = node;
          tail = node;
        }else{
          node.prev.next = node.next;
          node.prev = null;
          node.next = head;
          head.prev = node;
          head = node;
        }
      }
      currentSize++;
      currentAvg = (currentAvg + node.value)/currentSize;
    }
  
    @Override
    public Integer get(String key){
      final Node node = map.get(key);
      if(node != null && node.ttl > Instant.now()){
        return node.value;
      }
      return null;
    }
  
    @Override
    public double getAverage(){
      final Node node = tail;
      int total;
      while(tail.ttl < Instant.now()){
        total = total + tail.ttl;
      }
      return (currentAvg*currentSize - total)/currentSize;
    }
  
    void expire(){
      
    }
}

class Node{
  String key;
  int value;
  int ttl;
  Node next;
  Node prev;
  
  public Node(String key, int value, int ttl){
    this.key = key;
    this.value = value;
    this.ttl = ttl;
  }
}