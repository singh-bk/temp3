package com.thread.www;

public class Thread2 implements Runnable{

	private ThreadSafe obj = null;
	public Thread2(ThreadSafe obj)
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
		this.obj.setData(15);
		if(!this.obj.isIs_started())
			this.obj.setIs_started(true);
		else
			this.obj.setIs_started(false);
		System.out.println(this.obj.getData()+ " "+this.obj.isIs_started());
	}

}
