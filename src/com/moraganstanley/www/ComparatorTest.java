package com.moraganstanley.www;

import java.util.Arrays;

public class ComparatorTest {

	public static void main(String[] args){
		Class1 obj1 = new Class1(10);
		Class2 obj2 = new Class2(10);
		
		Object[] obj = new Object[2];
		obj[0] = obj1;
		obj[1] = obj2;
		Arrays.sort(obj, new MyComparator());
		System.out.println(Arrays.toString(obj));
	}
}
