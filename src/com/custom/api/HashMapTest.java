package com.custom.api;

public class HashMapTest {

	public static void main(String[] args){
		HashMap map = new HashMap();
		map.put("abc", "One");
		map.put("bcd", "Two");
		map.put("cde", "Three");
		map.put("acb", "Four");
		System.out.println(map.get("abc"));
	}
}
