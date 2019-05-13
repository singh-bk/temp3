package com.heap.www;

import java.util.Arrays;

public class RemoveDuplicatesUsingMergeSort {

	public static void main(String[] args){
		int[] input = {3,4,1,2,7,8,9,2};
		MergeSort(input,0,input.length);
		System.out.println(Arrays.toString(input));
		
	}
	
	/**
	 * 
	 * @param input
	 * @param start
	 * @param end
	 */
	public static void MergeSort(int[] input, int start, int end){
		int mid = (start+end)/2;
		if(start < end){
			MergeSort(input, start, mid);
			MergeSort(input, mid+1, end);
			Merge(input, start, mid, end);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param start
	 * @param mid
	 * @param end
	 */
	public static void Merge(int[] input, int start, int mid, int end){
		int i= start;
		int j = mid+1;
		while(i<mid && j<end){
			if(input[i] < input[j]){
				i++;
			}
			else if(input[j] < input[i]){
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				j++;
			}
		}
	}
}
