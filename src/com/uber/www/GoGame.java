package com.uber.www;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoGame {

    static Map<Coordinate, String>          map;
    // static Set<Coordinate> similarNeighbors;
    static Map<Coordinate, Set<Coordinate>> similarNeighborsMap;
    static Set<Coordinate>                  alreadyCaptured;

    public static void main(String[] args) {
        final GoGame obj = new GoGame();
        map = obj.init();
        // similarNeighbors = new HashSet<Coordinate>();
        similarNeighborsMap = new HashMap<Coordinate, Set<Coordinate>>();
        alreadyCaptured = new HashSet<Coordinate>();
        System.out.println(obj.isCaptured(3, 2));
    }


    public boolean isCaptured(int x, int y) {
        final Coordinate co = new Coordinate(x, y);
        boolean captured = true;
        final String val = map.get(co);
        final Set<Coordinate> similarNeighbors = new HashSet<Coordinate>();
        if (val == null) {
            return false;
        } else {
            int start = 1;
            final Coordinate one = new Coordinate(x - start, y);
            if (map.get(one) == null) {
                return false;
            } else if (map.get(one).equals(val) && !alreadyCaptured.contains(one)) {
                similarNeighbors.add(one);
            }
            start = 1;
            final Coordinate two = new Coordinate(x + start, y);

            if (map.get(two) == null) {
                return false;
            } else if (map.get(two).equals(val) && !alreadyCaptured.contains(two)) {
                similarNeighbors.add(two);
            }
            start = 1;
            final Coordinate three = new Coordinate(x, y - start);

            if (map.get(three) == null) {
                return false;
            } else if (map.get(three).equals(val) && !alreadyCaptured.contains(three)) {
                similarNeighbors.add(three);
            }
            start = 1;
            final Coordinate four = new Coordinate(x, y + start);

            if (map.get(four) == null) {
                return false;
            } else if (map.get(four).equals(val) && !alreadyCaptured.contains(four)) {
                similarNeighbors.add(four);
            }
        }
        alreadyCaptured.add(co);
        final Iterator<Coordinate> iter = similarNeighbors.iterator();
        while (iter.hasNext()) {
            final Coordinate cc = iter.next();
            captured = captured && isCaptured(cc.x, cc.y);
        }
        return captured;
    }

    public Map<Coordinate, String> init() {
        final Map<Coordinate, String> map = new HashMap<Coordinate, String>();
        final Coordinate one = new Coordinate(1, 2);
        map.put(one, "x");
        final Coordinate two = new Coordinate(2, 1);
        map.put(two, "x");
        final Coordinate three = new Coordinate(2, 2);
        map.put(three, "o");
        final Coordinate four = new Coordinate(2, 3);
        map.put(four, "x");
        final Coordinate five = new Coordinate(3, 1);
        map.put(five, "x");
        final Coordinate six = new Coordinate(3, 2);
        map.put(six, "o");
        final Coordinate seven = new Coordinate(3, 3);
        map.put(seven, "o");
        final Coordinate eight = new Coordinate(3, 4);
        // map.put(eight, "x");
        final Coordinate nine = new Coordinate(4, 2);
        map.put(nine, "x");
        final Coordinate ten = new Coordinate(4, 3);
        map.put(ten, "x");
        return map;
    }


}


class Coordinate {
    int x;
    int y;

    Coordinate(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public boolean equals(Object obj) {
        return this.x == ((Coordinate) obj).x && this.y == ((Coordinate) obj).y;
    }

    @Override
    public int hashCode() {
        return 10 * x + 1 + y;
    }
}
