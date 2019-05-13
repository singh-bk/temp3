package com.groupon.www;

public class Test {

	public static void main(String[] args) {
		SampleBlockingPoolImpl pool = new SampleBlockingPoolImpl(10);
		System.out.println(pool.size());
		Sample sample = pool.get();
		System.out.println(sample);
		System.out.println(pool.size());
		pool.release(sample);
		System.out.println(pool.size());
	}
}
