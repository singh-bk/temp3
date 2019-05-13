package com.pattern.design.www;

public class Singleton {

	private volatile static Singleton instance;
	private Singleton(){
		System.out.println("Instance Created");
	}
	
	public static Singleton GetInstance()
	{
		if(instance == null)
		{
			synchronized(Singleton.class)
			{
				if(instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
}
