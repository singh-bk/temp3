package com.thread.www;

public class PrintOddRunnable implements Runnable{

	private int count = 1;
	private boolean running = true;
	
	public boolean getRunning(){
		return this.running;
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}
	@Override
	public void run() {
		while(this.getRunning())
		{
			
		}
	}

}
