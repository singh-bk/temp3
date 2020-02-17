package com.leetcode.twilio;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node               head;
    Node               tail;
    int                len;
    int                MAX_LEN;

    public LRUCache(int capacity) {
        MAX_LEN = capacity;
    }

    public int get(int key) {
        final Node node = map.get(key);
        if (node != null) {

            if (node.key == head.key) {
                // do nothing
            } else if (node.key == tail.key) {
                final Node old_tail = tail;
                tail = old_tail.prev;
                tail.next = null;
                
                node.prev = null;
                head.prev = node;
                node.next = head;
                head = node;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                head.prev = node;
                node.next = head;
                head = node;
            }

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            if (node.val != value) {
                node.val = value;
            }
            if (head.key == tail.key) { // this by default means head=node and tail =node
                if (node.val != head.val) {
                    head = node;
                    tail = node;
                    System.out.println("This should not be printed. Even in updated");
                }
            } else if (tail.key == node.key) {
                final Node old_tail = tail;
                tail = old_tail.prev;
                tail.next = null;
                node.prev = null;
                head.prev = node;
                node.next = head;
                head = node;
            } else if (head.key != node.key) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                final Node old_head = head;
                head = node;
                head.next = old_head;
                old_head.prev = head;
            }
            len++;
            if(len > MAX_LEN) {
                tail.prev.next = null;
                map.remove(tail.key);
                tail = tail.prev;
            }
        }
    }


    class Node {
        int  key;
        int  val;
        Node prev;
        Node next;

        Node(int x, int y) {
            key = x;
            val = y;
        }
    }
}
