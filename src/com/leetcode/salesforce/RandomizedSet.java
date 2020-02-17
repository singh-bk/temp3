package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    LinkedHashMap<Integer, Integer> map;
    List<Integer>                   list;
    int                             size;

    public RandomizedSet() {
        map = new LinkedHashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        size = 0;
    }

    public boolean insert(int val) {
        if (map.get(val) == null) {
            list.add(val);
            map.put(val, size);
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        final Integer index = map.remove(val);
        if (index != null) {
            final int last = list.get(size-1);
            list.set(index, last);
            if(index != size-1) {
                map.put(last, index);
            }
            list.remove(size-1);
            size--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (size > 0) {
            final int index = ThreadLocalRandom.current().nextInt(size);
            return list.get(index);
        } else {
            return -1;
        }

    }
}
