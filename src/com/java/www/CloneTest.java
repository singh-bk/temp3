package com.java.www;

public class CloneTest{

	public static void main(String[] args){
		Clone cl = new Clone();
		try{
			Clone cl2 = (Clone)cl.clone();
			System.out.println(cl2.getClass());
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
	}
}
