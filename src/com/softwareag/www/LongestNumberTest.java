package com.softwareag.www;

import java.util.Arrays;
import java.util.Comparator;

public class LongestNumberTest implements Comparator<Integer>{

	public static void main(String[] args)
	{
		Integer[] input = {7,110,11};
		LongestNumberTest obj = new LongestNumberTest();
		Arrays.sort(input, obj);
		System.out.println(Arrays.toString(input));
	}

	@Override
	public int compare(Integer arg0, Integer arg1) {
		String str1 = arg0.toString()+arg1.toString();
		String str2 = arg1.toString()+arg0.toString();
		
		return str1.compareTo(str2);
	}

}
