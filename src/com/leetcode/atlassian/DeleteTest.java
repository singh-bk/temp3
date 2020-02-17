package com.leetcode.atlassian;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteTest {

    public static void main(String[] args) {
       removeWithIter();
       removeWithRemoveif();
       removeWithStream();
    }
    
    public static void removeWithStream() {
        final List<String> list = new ArrayList<String>();
        list.add("asdasd");
        list.add("erer");
        list.add("asdrersd");
        list.add("asdareresd");
        list.add("asdwerweasd");
        list.add("asdasdwerew");
        System.out.println(list);
        final List<String> list2 = list.stream().filter(str-> !str.equals("erer")).collect(Collectors.toList());
        System.out.println(list2);
    }
    
    public static void removeWithRemoveif() {
        final Set<String> list = new HashSet<String>();
        list.add("asdasd");
        list.add("erer");
        list.add("asdrersd");
        list.add("asdareresd");
        list.add("asdwerweasd");
        list.add("asdasdwerew");
        System.out.println(list);
        list.removeIf(str-> str.equals("erer"));
        System.out.println(list);
    }
    
    public static void removeWithIter() {
        final Set<String> list = new HashSet<String>();
        list.add("asdasd");
        list.add("erer");
        list.add("asdrersd");
        list.add("asdareresd");
        list.add("asdwerweasd");
        list.add("asdasdwerew");
        System.out.println(list);
        final Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals("erer")) {
                iter.remove();
            }
        }
        System.out.println(list);
    }
}
