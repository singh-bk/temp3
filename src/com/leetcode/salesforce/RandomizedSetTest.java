package com.leetcode.salesforce;

public class RandomizedSetTest {

    public static void main(String[] args) {
        final RandomizedSet set = new RandomizedSet();
        
        System.out.println(set.insert(3));
        System.out.println(set.remove(3));
        System.out.println(set.remove(0));
        System.out.println(set.remove(3));
        System.out.println(set.map);
        
        
        System.out.println(set.insert(0));
        System.out.println(set.remove(0));
        System.out.println(set.map);
        System.out.println(set.list);
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        
        System.out.println(set.map);
        System.out.println(set.list);
        System.out.println(set.insert(1));
        System.out.println(set.map);
        System.out.println(set.list);
        System.out.println(set.remove(0));
        System.out.println(set.map);
        System.out.println(set.list);

        System.out.println(set.insert(2));
        System.out.println(set.map);
        System.out.println(set.list);
        System.out.println(set.remove(1));
        System.out.println(set.map);
        System.out.println(set.list);
        
        System.out.println(set.getRandom());
    }
}
