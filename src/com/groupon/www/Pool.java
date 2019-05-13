package com.groupon.www;

import java.util.concurrent.TimeUnit;

public interface Pool<T> {

	T get();
	
	T get(long time, TimeUnit unit);
	
	void release(T t);
	
	void shutdown();
	
	int size();
}
