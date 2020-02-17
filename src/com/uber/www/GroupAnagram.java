package com.uber.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagram {

    public static void main(String[] args) {
        final String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final GroupAnagram obj = new GroupAnagram();
        System.out.println(obj.groupAnagrams(input));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> op = new ArrayList<List<String>>();
        final Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            final char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);

            List<String> list = map.get(new String(ch));
            if (list != null) {
                list.add(strs[i]);
            } else {
                list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(new String(ch), list);
            }
        }
        final Set<String> keys = map.keySet();
        for (final String key : keys) {
            final List<String> val = map.get(key);
            op.add(val);
        }
        return op;
    }
}
