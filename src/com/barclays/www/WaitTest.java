package com.barclays.www;

public class WaitTest {

	public static void main(String[] args) throws InterruptedException{
		Object obj = new Object();
		int count = 0;
		synchronized(obj){
			while(count < 10)
				obj.wait();
			count++;
		}
		System.out.println("here");
	}
}
