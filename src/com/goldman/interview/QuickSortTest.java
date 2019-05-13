package com.goldman.interview;

public class QuickSortTest {

	static int[] input = {1,5,6,2,3,4,7,8,9,11,10,15,16,12,13,14};
	public static void main(String[] args){
		
		int len = input.length-1;
		int pivot = 5;
		
		QuickSort(pivot, 0, len);
	}
	
	public static void QuickSort(int pivot, int start, int end)
	{
		while(input[start] < pivot)
			start++;
		
	}
}
