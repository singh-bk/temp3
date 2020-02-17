package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentWords {

    public static void main(String[] args) {

        final KFrequentWords obj = new KFrequentWords();
        final String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        final int k = 4;
        System.out.println(obj.topKFrequent(words, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        final PriorityQueue<Node> heap = new PriorityQueue<Node>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                // TODO Auto-generated method stub
                if (o1.count > o2.count) {
                    return 1;
                } else if (o1.count < o2.count) {
                    return -1;
                } else if (o1.count == o2.count) {
                    return (o2.val.compareTo(o1.val));
                } else {
                    return 0;
                }
            }
        });

        for (final String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (final String word : map.keySet()) {
            final Node node = new Node(word, map.get(word));
            heap.offer(node);
            if (heap.size() > k) {
                heap.poll();
            }
        }


        final List<String> ans = new ArrayList<String>();
        while (!heap.isEmpty())
            ans.add(heap.poll().val);
        Collections.reverse(ans);
        return ans;
    }

    class Node {
        String val;
        int    count;

        Node(String v, int c) {
            val = v;
            count = c;
        }
    }
}
