package com.groupon.www;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class BlockingPool<T> implements Pool<T>, ObjectFactory<T>{

	private int size;
	private BlockingQueue<T> objects;
	
	public BlockingPool(int size){
		this.size = size;
		objects = new LinkedBlockingQueue<T>();
		for(int i=0;i<size;i++){
			objects.add(create());
		}
	}
	
	@Override
	public T get() {
		T t = null;
		try{
			t = objects.take();
		}catch(InterruptedException ex){
			System.out.println(ex);
		}
		return t;
	}

	@Override
	public T get(long timeout, TimeUnit unit) {
		T t = null;
		try{
			t = objects.poll(timeout, unit);
		}catch(InterruptedException ex){
			System.out.println(ex);
		}
		return t;
	}

	@Override
	public void release(T t) {
		objects.offer(t);
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size(){
		return objects.size();
	}
}
