package com.microsoft.interview;

import java.util.TreeMap;

public class CalendarTest {

    public static void main(String[] args) {
        final TreeMap<Integer, Event> map = new TreeMap<Integer, Event>();
        final CalendarTest obj = new CalendarTest();
        System.out.println(obj.schedule(1000, 1030, map));
        System.out.println(obj.schedule(1030, 1130, map));
        System.out.println(obj.schedule(1100, 1130, map));
        System.out.println(obj.schedule(1130, 1200, map));
        System.out.println(obj.schedule(930, 1000, map));
        System.out.println(obj.schedule(1000, 1030, map));
        System.out.println(obj.schedule(1000, 1030, map));
        System.out.println(obj.schedule(1000, 1030, map));
        System.out.println(obj.schedule(1000, 1030, map));
        System.out.println(obj.schedule(1000, 1030, map));
    }

    public boolean schedule(int startTime, int endTime, TreeMap<Integer, Event> map) {
        Event event = map.get(startTime);
        if (event != null) {
            return false;
        } else {
            final Integer prev = map.floorKey(startTime);
            final Integer next = map.ceilingKey(startTime);
            if ((prev == null || map.get(prev).endTime <= startTime)
                            && (next == null || map.get(next).startTime >= endTime)) {
                event = new Event(startTime, endTime);
                map.put(startTime, event);
                return true;
            }
        }
        return false;
    }


}
