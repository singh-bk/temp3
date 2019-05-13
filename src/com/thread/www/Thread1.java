package com.thread.www;

public class Thread1 implements Runnable{

	private ThreadSafe obj = null;
	public Thread1(ThreadSafe obj)
	{
		this.obj = obj;
	}
	
	
	public ThreadSafe getObj() {
		return obj;
	}


	public void setObj(ThreadSafe obj) {
		this.obj = obj;
	}


	@Override
	public void run() {
		this.obj.setData(5);
		if(!this.obj.isIs_started())
			this.obj.setIs_started(true);
		else
			this.obj.setIs_started(false);
		System.out.println(this.obj.getData()+ " "+this.obj.isIs_started());
	}

}
