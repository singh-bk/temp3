package com.thread2.www;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClass {

	private int data;
	private  ReentrantLock lock = new ReentrantLock();
	
	public ReentrantLockClass(int data){
		this.data = data;
	}
	
	public void setData(int data){
		lock.lock();
		try{
			data++;
			System.out.println("New data:"+data);
		}
		finally{
			lock.unlock();
		}
	}
	
	public int getData(){
		return data;
	}
}
