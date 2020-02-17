package com.leetcode.twilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        final List<String> input = new ArrayList<String>();
        input.add("code");
        input.add("aaagmnrs");
        input.add("anagrams");
        input.add("doce");
        
        final Anagram obj = new Anagram();
        System.out.println(funWithAnagrams(input));
        
    }

    public static List<String> funWithAnagrams(List<String> text) {
        final List<String> op = new ArrayList<String>();
        final Iterator<String> iter = text.iterator();
        final Map<String, Integer> map2 = new HashMap<String, Integer>();
        final String prev = null;
        int index = 0;
        while(iter.hasNext()){
            final String current = iter.next();
            final char[] temp = current.toCharArray();
            Arrays.sort(temp);
            if(map2.getOrDefault(String.valueOf(temp), -1) > -1) {
                //do nothing
            }else {
                map2.put(String.valueOf(temp), index);
            }
            index++;
             
        }
        for(final String key: map2.keySet()) {
            final int ii = map2.get(key);
            op.add(text.get(ii));
        }
        Collections.sort(op);
        return op;
    }
}
