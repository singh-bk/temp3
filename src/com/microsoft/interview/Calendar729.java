package com.microsoft.interview;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Calendar729 {

    TreeMap<Integer, Integer> map;

    public Calendar729() {
        map = new TreeMap<Integer, Integer>();
    }

    public static void main(String[] args) {
        final Calendar729 cal = new Calendar729();
        final int start = 0;
        final int end = 2;
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 25));
        System.out.println(cal.book(20, 30));
    }

    public boolean book(int start, int end) {
        final Entry<Integer, Integer> prev = map.floorEntry(start);
        final Entry<Integer, Integer> next = map.ceilingEntry(start);

        if ((end <= start) || (prev != null && start < prev.getValue()) || (next != null && end > next.getKey())) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}


