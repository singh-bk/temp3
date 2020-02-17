package com.uber.www;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list = Collections.unmodifiableList(list);
        // list.add("adas");
        System.out.println(list);

        final List<Integer> ll = new ArrayList<Integer>();
        ll.add(100);
        ll.add(200);
        ll.add(300);
        System.out.println(ll);
        ll.remove(ll.size() - 1);
        System.out.println(ll);
    }


    public List<String> findDistinctPairs(int[] input, int k) {
        final Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < input.length; i++) {
            final List<Integer> list = map.getOrDefault(input[i], new ArrayList<Integer>());
            list.add(i);
        }
        final List<String> op = new ArrayList<String>();
        final Set<Integer> keys = map.keySet();
        for (final int key : keys) {

            final List<Integer> ll = map.get(k - key);
            if (ll != null && ll.size() > 0) {
                final StringBuilder sb = new StringBuilder("");
                sb.append(key);
                sb.append(k - key);
                ll.remove(ll.size() - 1);
                op.add(sb.toString());
            }
        }
        return op;
    }
}
