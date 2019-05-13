package com.concurrent.www;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerUtils {

	private static AtomicInteger atomic = new AtomicInteger(0);
	
	public static AtomicInteger Get(){
		return atomic;
	}
}
