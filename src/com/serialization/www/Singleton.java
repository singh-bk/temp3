package com.serialization.www;

import java.io.Serializable;

public class Singleton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7604766932017737115L;
	
	private static Singleton instance;
	private Singleton(){}
	
	public static Singleton GetInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	protected Object writeReplace(){
		System.out.println("Calling Write Replace");
		return GetInstance();
	}
	
	
	protected Object readResolve(){
		System.out.println("calling Read Resolve");
		return GetInstance();
	}
	
}
