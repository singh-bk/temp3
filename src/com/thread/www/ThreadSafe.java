package com.thread.www;

public class ThreadSafe {

	private int data;
	private boolean is_started;
	
	public int getData() {
		return data;
	}
	
	public synchronized void setData(int data) {
		this.data = data;
	}
	public boolean isIs_started() {
		return is_started;
	}
	
	public synchronized void setIs_started(boolean is_started) {
		this.is_started = is_started;
	}
	
	
}
