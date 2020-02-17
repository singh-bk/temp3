package com.uber.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistinctPair {

    public static void main(String[] args) {
        final int[] input = {11, 10, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9};
        final int sum = 10;
        final DistinctPair pair = new DistinctPair();
        final List<String> ss = pair.findDistinctPairs(input, sum);
        System.out.println(ss);
    }

    public List<String> findDistinctPairs(int[] input, int sum) {
        final List<String> op = new ArrayList<String>();
        final Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < input.length; i++) {
            List<Integer> list = map.get(input[i]);
            if (list == null) {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(input[i], list);
            } else {
                list.add(i);
            }
        }

        final Set<Integer> keys = map.keySet();
        for (final int key : keys) {
            while (map.get(key) != null && map.get(key).size() > 0) {
                final int diff = sum - key;

                if (map.get(diff) != null && map.get(diff).size() > 0) {
                    final StringBuilder sb = new StringBuilder("");
                    sb.append(key);
                    sb.append(diff);
                    final List<Integer> one = map.get(key);
                    final List<Integer> two = map.get(diff);
                    one.remove(one.size() - 1);
                    two.remove(two.size() - 1);
                    op.add(sb.toString());
                } else {
                    break;
                }
            }
        }

        return op;
    }
}
