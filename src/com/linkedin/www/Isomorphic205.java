package com.linkedin.www;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic205 {
    public static void main(String[] args) {
        final Isomorphic205 obj = new Isomorphic205();
        System.out.println(obj.isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        final Map<Character, Character> map = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();
        final char[] ch1 = s.toCharArray();
        final char[] ch2 = t.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            final Character tt = map.get(ch1[i]);
            final Character dd = map2.get(ch2[i]);
            if ((tt == null && dd != null) || (tt != null && dd == null)) {
                return false;
            }else if(tt != null && dd != null && !(tt.equals(ch2[i]) && dd.equals(ch1[i]))){
                return false;
            }else {
                map.put(ch1[i], ch2[i]);
                map2.put(ch2[i], ch1[i]);
            }
        }
        return true;
    }
}
