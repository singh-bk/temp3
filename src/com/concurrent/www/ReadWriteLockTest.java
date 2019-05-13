package com.concurrent.www;


public class ReadWriteLockTest {

	public static void main(String[] args) {
		ReadWriteLockMap map = new ReadWriteLockMap();
		map.put("1", "BK");
		map.put("1", "BKW");
		map.put("1", "BKS");
		map.put("1", "BKR");
		
		System.out.println(map.get("1"));
	}
}
