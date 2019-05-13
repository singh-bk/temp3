package com.concurrentutil.java;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args) throws InterruptedException{
		WeakHashMap<String, String> weak = new WeakHashMap<String, String>();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<100000;i++){
			String str = i+"";
			weak.put(str,str+"value");
			map.put(str,str+"value");
		}
		System.gc();
		Thread.sleep(1000);
		System.out.println(weak.size());
	}
}
