package com.uber.www;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {

	private Map<String, String> map;
	
	public Cache(final int len){
		this.map = new LinkedHashMap<String, String>(){
			@Override
			protected boolean removeEldestEntry(
					java.util.Map.Entry<String, String> eldest) {
				return size() > len;
			}
		};
		this.map = Collections.synchronizedMap(this.map);
	}
	
	public String getValue(String name){
		return map.get(name);
	}
	
	public int size(){
		return this.map.size();
	}
	
	public void add(String name, String value){
		map.put(name, value);
		
	}

}
