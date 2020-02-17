package com.uber.www;

import java.util.ArrayList;
import java.util.List;

public class Temp {

    public static void main(String[] args) {
        final List<Integer> ll = new ArrayList<Integer>();
        ll.add(1);
        System.out.println(ll);
        final Temp temp = new Temp();
        temp.get(ll);
        System.out.println(ll);
    }

    public boolean get(List<Integer> ll) {
        ll.remove(ll.size()-1);
        return true;

    }
}
