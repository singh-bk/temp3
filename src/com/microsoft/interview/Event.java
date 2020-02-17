package com.microsoft.interview;

import java.util.Comparator;

class Event implements Comparator<Event> {
    int startTime;
    int endTime;

    Event() {
        super();
    }

    Event(int st, int d) {
        startTime = st;
        endTime = d;
    }

    @Override
    public int compare(Event o1, Event o2) {
        return o1.startTime - o2.startTime;
    }

}
