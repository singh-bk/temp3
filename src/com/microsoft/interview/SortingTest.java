package com.microsoft.interview;

public class SortingTest {

	static int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	static int[] output = new int[input.length];

	public static void main(String... args) {
		
	}
	
	public static void mergeSort(int[] arr, int start, int end){
		while(start< end){
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
		}
	}
	
	public static void merge(int start, int middle, int end){
		int oddmid1 = -1;
		if(input[start]%2==)
	}
}
