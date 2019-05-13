package com.concurrent.www;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMap {

	ReadWriteLock lock = new ReentrantReadWriteLock();
	Lock writeLock = lock.writeLock();
	Lock readLock = lock.readLock();
	
	Map<String, String> map = new HashMap<String, String>();
	
	public void put(String key, String value){
		writeLock.lock();
		writeLock.lock();
		map.put(key, value);
		writeLock.lock();
		//writeLock.unlock();
	}
	
	public String get(String key){
		readLock.lock();
		String value = map.get(key);
		readLock.unlock();
		return value;
	}
}
