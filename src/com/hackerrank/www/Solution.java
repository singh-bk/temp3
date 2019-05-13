package com.hackerrank.www;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int socks[] = new int[count];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i < count; i++){
        	int key = in.nextInt();
        	Integer val = map.get(key);
        	if(val != null){
        		val++;
        		map.put(key, val);
        	}else{
        		val = 1;
        		map.put(key, 1);
        	}
        }
        
        Set<Integer> keys = map.keySet();
        int match = 0;
        for(Integer key: keys){
        	match = match + (map.get(key)/2);
        }
        System.out.println(match);
    }
}