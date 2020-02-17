package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    public static void main(String[] args) {
        final AllAnagrams obj = new AllAnagrams();
        final String s = "abab";
        final String p = "ab";
        System.out.println(obj.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> list = new ArrayList<Integer>();
        final Map<Character, Integer> wordMap = new HashMap<Character, Integer>();
        final Map<Character, Integer> tempMap = new HashMap<Character, Integer>();

        for (final char ch : p.toCharArray()) {
            wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);

        }

        tempMap.putAll(wordMap);

        int start = -1;
        int end = -1;
        final boolean found = false;
        int currentLen = 0;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            final Integer val = tempMap.get(ch);
            if(val == null) {
                start = -1;
                end = -1;
                tempMap.putAll(wordMap);
            }
            else if (val == 0) {
                if(currentLen == 0) {
                    
                }else {
                    
                }
                start = start+1;
                end++;
                //tempMap.put(ch, 1);
                //do not increment currentLen
            } else {
                if (start == -1) {
                    start = i;
                    end = i;
                    currentLen = 1;
                } else {
                    end++;
                    currentLen++;
                }
                tempMap.put(ch, val - 1);
                
                if (currentLen == wordMap.size()) {
                    list.add(start);
                    for(int tt=start+; tt<=i;tt++) {
                        tempMap.put(s.charAt(tt), tempMap.getOrDefault(s.charAt(tt), 0)+1);
                    }
                    start = start+1;
                    currentLen--;
                }
            }
        }
        return list;
    }
}
