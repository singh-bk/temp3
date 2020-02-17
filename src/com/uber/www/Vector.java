package com.uber.www;

import java.util.HashMap;
import java.util.Map;

public class Vector {

    public static void main(String[] args) {
        final int[][] input =  {{1,3},{2,3},{1,4},{1,100},{91,100},{91,92},{91,95},{91,96}};
        final Vector vec = new Vector();
        vec.maxInterval(input);
        
    }
    
    public int[] maxInterval(int[][] input) {
        final int[] op = new int[2];
        //int[] temp = new int[input.length];
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int minInterval = 99999;
        int maxInterval = 0;
        
        for(int i=0;i<input.length;i++) {
            
            final int start = input[i][0];
            final int end = input[i][1];
            if(minInterval > start) {
                minInterval = start;
            }
            if(maxInterval < end) {
                maxInterval = end;
            }
            for(int k =start;k<=end; k++) {
                map.put(k, map.getOrDefault(k, 0)+1);
            }
        }
        
        System.out.println(map);
        int prevMax = 0;
        int start = 0;
        int end = 0;
        int prevMaxIndex = -1;
        for(int xx = minInterval; xx<=maxInterval;xx++) {
            final int curr = map.get(xx);
            if(curr == prevMax && prevMaxIndex == xx-1) {
                end = xx;
                prevMaxIndex = xx;
            }else if(curr > prevMax ) {
                start = xx;
                end = xx;
                prevMax = curr;
                prevMaxIndex = xx;
            }
            
        }
        System.out.println(start);
        System.out.println(end);
        return op;
    }
}
