package com.Komprise.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

        final Solution obj = new Solution();
        final int[] input = {1,1,1,1,1,1,3,4,15};
        System.out.println(obj.getHeight(input, 12));

    }

    public int getHeight(int[] input, int wood) {

        final int len = input.length;
        final Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int maxHeight = 0;
        int minHeight = 9999;
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.get(input[i]);
            if (list != null) {
                list.add(i);
            } else {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(input[i], list);
            }
            if (input[i] > maxHeight) {
                maxHeight = input[i];
            }
            if (input[i] < minHeight) {
                minHeight = input[i];
            }
        }
        int woodRemaining = wood;
        int woodCut = 0;

        int currentCount = 0;
        int prevHeight = maxHeight;
        int prevCount = map.get(maxHeight).size();
        int height = maxHeight;


        for (int x = maxHeight - 1; x >= minHeight; x--) {

            final List<Integer> ll = map.getOrDefault(x, new ArrayList<Integer>());


            if (ll.size() > 0) {
                currentCount = ll.size();
                final int diff = prevHeight - x;
                woodCut = woodCut + prevCount * diff;
                woodRemaining = wood - woodCut;
                prevCount = prevCount + currentCount;

                if (woodRemaining <= 0) {
                    height = x;
                    break;
                } else {
                    height = x;
                    prevHeight = x;
                }
            }

        }
        if (woodRemaining > 0) {
            height = height - (int) Math.ceil(((double) woodRemaining) / len);
        }
        return height;

    }

}
