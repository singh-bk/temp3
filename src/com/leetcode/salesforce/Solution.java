package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {


    static Map<String, String> globalMap;

    Solution() {
        globalMap = new HashMap<String, String>();
    }

    public static void main(String[] args) {
        final Solution obj = new Solution();
        final String input = "SET A 100";
        final String op[] = obj.parse(input);
        final String command = op[0];
        final String key = op[1];
        String value = null;
        if (op.length > 2) {
            value = op[2];
        }
        final List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
        maps.add(globalMap);
        System.out.println(obj.execute("SET", "A", "100", maps));
        System.out.println(obj.execute("GET", "A", null, maps));
        System.out.println(obj.execute("DELETE", "B", null, maps));
        System.out.println(obj.execute("COUNT", "100", null, maps));
        System.out.println(obj.execute("START", null, null, maps));
        System.out.println(obj.execute("COUNT", "100", null, maps));
        System.out.println(obj.execute("SET", "B", "1000", maps));
        System.out.println(obj.execute("SET", "A", "1000", maps));
        System.out.println(obj.execute("COUNT", "1000", null, maps));
        System.out.println(obj.execute("COUNT", "100", null, maps));
        System.out.println(obj.execute("END", null, null, maps));
        System.out.println(obj.execute("COUNT", "1000", null, maps));
        System.out.println(obj.execute("COUNT", "100", null, maps));

    }

    public String[] parse(String input) {
        final StringTokenizer tokens = new StringTokenizer(input);
        final String[] output = new String[tokens.countTokens()];
        int i = 0;
        while (tokens.hasMoreTokens()) {
            output[i] = tokens.nextToken();
            i++;
        }
        return output;
    }

    public String execute(String command, String key, String value, List<Map<String, String>> maps) {
        final Helper helper = new Helper();
        String result = null;

        switch (command) {
            case "SET":
                final boolean res = helper.set(key, value, maps.get(maps.size() - 1));
                result = (res) ? "SUCCESS" : "FAILURE";
                break;
            case "GET":
                result = helper.get(key, maps.get(maps.size() - 1));
                break;
            case "DELETE":
                final boolean del = helper.delete(key, maps.get(maps.size() - 1));
                result = (del) ? "SUCCESS" : "FAILURE";
                break;
            case "COUNT":
                result = helper.count(key, maps.get(maps.size() - 1));
                break;
            case "START":
                final Map<String, String> copyMap = new HashMap<String, String>();
                copyMap.putAll(maps.get(maps.size() - 1));
                maps.add(copyMap);
                break;
            case "END":
                maps.remove(maps.get(maps.size() - 1));
                break;
        }
        return result;
    }

    class Helper {
        public boolean set(String key, String value, Map<String, String> localMap) {
            String oldVal = null;
            oldVal = localMap.put(key, value);
            localMap.put(key, value);
            return (oldVal == null || !oldVal.equals(value));
        }

        public String get(String key, Map<String, String> localMap) {
            return localMap.get(key);
        }

        public boolean delete(String key, Map<String, String> localMap) {
            String val = null;
            val = localMap.remove(key);
            return (val != null);
        }

        public String count(String value, Map<String, String> localMap) {
            int count = 0;
            for (final String key : localMap.keySet()) {
                if (localMap.get(key) != null && localMap.get(key).equals(value)) {
                    count++;
                }
            }
            return count + "";
        }
    }
}
