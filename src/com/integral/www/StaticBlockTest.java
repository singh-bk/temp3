package com.integral.www;

import java.util.LinkedList;

public class StaticBlockTest {

	static LinkedList<Integer> list = new LinkedList<Integer>();
	//int num;
	static 
	{
		try
		{
			list.add(1);
			list.add(2);
			list.add(Integer.parseInt("One"));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		System.out.println("Here");
		System.out.println("Here");
		System.out.println("Here");
		System.out.println("Here");
	}
}
