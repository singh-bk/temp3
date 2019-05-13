package com.goldman.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

	public static void main(String[] args){
		LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<Integer, Boolean>();
		map.put(0, true);
		map.put(5, true);
		map.put(9, true);
		map.put(5, true);
		map.put(6, true);
		map.put(7, true);
		map.put(6, true);
		map.put(9, true);
		
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext())
		{
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
