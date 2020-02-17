package com.threadsafe.www;

import java.util.HashMap;
import java.util.Map;

public class Sample {

    private static final Map<String, String> map = new HashMap<>();;



    public static void set(String key, String value) {
        map.put(key, value);
    }

    public static String get(String key) {
        return map.get(key);
    }
}
