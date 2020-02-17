package com.linkedin.www;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

class RetainBestCache2<K, V extends Abc> {

    PriorityQueue<Node<K, V>> queue;
    int                       size;
    Map<K, Node<K, V>>        map;
    DataSource                dataSource;

    public RetainBestCache2(DataSource ds, int entriesToRetain) {
        queue = new PriorityQueue<Node<K, V>>(entriesToRetain, new Comparator<Node<K, V>>() {

            @Override
            public int compare(Node<K, V> o1, Node<K, V> o2) {
                if(o1.v.getRank() > o2.v.getRank()) {
                    return 1;
                }else if(o2.v.getRank() > o1.v.getRank()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        size = entriesToRetain;
        map = new ConcurrentHashMap<K, Node<K, V>>();
        dataSource = ds;
    }

    public V get(K key) {
        final Node<K, V> node = map.get(key);
        if (node != null) {
            return node.v;
        } else {
            final V v1 = (V) dataSource.get(key);
            final Node<K, V> nn = new Node<K, V>(key, v1);
            map.put(key, nn);
            final Node<K, V> smallest = queue.remove();
            map.remove(smallest.k);
            queue.add(nn);
            return nn.v;
        }
    }
}


interface Abc {
    long getRank();
}


interface DataSource<K, V extends Abc> {
    V get(K key);
}


class Node<K, V extends Abc> {
    K k;
    V v;

    Node(K kk, V vv) {
        k = kk;
        v = vv;
    }
}
