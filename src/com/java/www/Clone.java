package com.java.www;

import java.util.Date;

public class Clone implements Cloneable{

	Date date;
	
	public Clone(){
		this.date = new Date();		
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		System.out.println("Clone Called");
		return super.clone();
	}
}
