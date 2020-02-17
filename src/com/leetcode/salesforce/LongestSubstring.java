package com.leetcode.salesforce;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        final String s = "tmmzuxt";
        final LongestSubstring obj = new LongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (s.length() > 0) {
            map.put(s.charAt(0), 0);
            max = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            final char ch = s.charAt(i);
            final Integer oldIndex = map.get(ch);
            if (oldIndex == null || oldIndex < start) {

                end++;
                if (end - start >= max) {
                    max = end - start + 1;
                }
                map.put(ch, i);
            } else {


                map.put(ch, i);
                start = oldIndex + 1;
                end++;
                if (end - start + 1 > max) {
                    max = end - start + 1;
                }
            }
        }
        return max;
    }
}
