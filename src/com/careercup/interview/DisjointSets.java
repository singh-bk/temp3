package com.careercup.interview;

import java.util.HashSet;

public class DisjointSets {

	public static void main(String...strings )
	{
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(9);
		set1.add(6);
		set1.add(7);
		
		set2.add(4);
		set2.add(11);
		set2.add(12);
		
		int[] array1 = {1,2,3,4,6,7,8,9,10,13};
		int[] array2 = {5,11,12,13};
		int[] array3 = {4,11,13,15,17,18};
		int[] array4 = {7,10,13,14,16,18,22,57};
		
		//sort array1, array2, array3
		//end sort
		int len1 = array1.length;
		int len2 = array2.length;
		boolean isDisjoint = CheckForDisjoint(array1, array2, len1, len2);
		System.out.println(isDisjoint);
	}
	
	public static boolean CheckForDisjoint(int[] array1, int[] array2, int len1, int len2)
	{
		int i=0,j=0;
		boolean isDisjoint = true;
		while(i<len1 && j <len2)
		{
			if(array1[i]<array2[j])
				i++;
			else if(array1[i]>array2[j])
				j++;
			else if(array1[i]==array2[j])
			{
				isDisjoint = false;
				break;
			}
				
		}
		return isDisjoint;
	}
}
