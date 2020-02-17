package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MergeInterval {

    public static void main(String[] args) {
        final MergeInterval obj = new MergeInterval();
        final int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
        obj.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        final List<int[]> merged = new ArrayList<int[]>();
        final Set<Integer> set = new TreeSet<Integer>();
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (final int[] interval : intervals) {
            final int first = interval[0];
            final int last = interval[1];
            if (map.get(first) != null) {
                final int prev = map.get(first);
                if (prev < last) {
                    map.put(first, last);
                }
            } else {
                map.put(first, last);
                set.add(first);
            }
        }
        int first = -1;
        int last = -1;
        for (final int ss : set) {
            final int dd = map.get(ss);
            if (ss <= last) {
                if (dd >= last) {
                    final int[] elem = {first, dd};
                    merged.remove(merged.size() - 1);
                    merged.add(elem);
                    last = dd;
                }
                if (ss < first) {
                    first = ss;
                }
            } else {
                final int[] elem = {ss, dd};
                merged.add(elem);
                first = ss;
                last = dd;;
            }
        }
        final int[][] op = new int[merged.size()][];
        for (int i = 0; i < merged.size(); i++) {
            op[i] = merged.get(i);
        }
        return op;
    }
}
