package com.ardendertat.www;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArraySumPair {

	public static void main(String...strings)
	{
		int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int value = 19;
		int left = 0;
		int right = num.length-1;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		//sort the array
		while(left < right)
		{
			System.out.println();
			if(num[left]+num[right] == value)
			{
				result.put(num[left], num[right]);
				left++;
				right--;
			}
			else if(num[left]+num[right] < value)
			{
				System.out.print(left+" ");
				left++;
			}
			else if(num[left]+num[right] > value)
			{
				System.out.print(left+" ");
				right--;
			}
		}
		
		//Iterator iter = result.keySet().iterator();
		Iterator iter = result.entrySet().iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
}
