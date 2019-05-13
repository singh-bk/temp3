package com.map.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LinkedHashMapTest {

	public static void main(String[] args){
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		Map<String, Integer> map3 = new TreeMap<String, Integer>();
		
		map.put("Google",10);
		map.put("Facebook",15);
		map.put("Yahoo",7);
		map.put("Google",17);
		
		map2.put("Google",10);
		map2.put("Facebook",15);
		map2.put("Yahoo",7);
		
		map3.put("Google",10);
		map3.put("Facebook",15);
		map3.put("Yahoo",7);
		
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.print(entry.getKey()+" "+entry.getValue()+" ");
		}
		System.out.println();
		Iterator iter2 = map2.entrySet().iterator();
		while(iter2.hasNext()){
			Map.Entry entry = (Map.Entry)iter2.next();
			System.out.print(entry.getKey()+" "+entry.getValue()+" ");
		}
		System.out.println();
		Iterator iter3 = map3.entrySet().iterator();
		while(iter3.hasNext()){
			Map.Entry entry = (Map.Entry)iter3.next();
			System.out.print(entry.getKey()+" "+entry.getValue()+" ");
		}
	}
}
