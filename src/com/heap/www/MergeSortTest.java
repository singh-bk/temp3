package com.heap.www;

public class MergeSortTest {

	private static int[] input = {3,4,1,2,7,8,9,2};
	private static int[] output = new int[input.length];
	public static void main(String[] args){
		
		MergeSort(0, input.length-1);
		for(int i=0;i<input.length;i++)
			System.out.print(input[i]+" ");
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 */
	public static void MergeSort(int start, int end){
		int middle = (start+end)/2;
		if(start<end)
		{
			MergeSort(start, middle);
			MergeSort(middle+1, end);
			Merge(start, middle, end);
		}
	}
	
	/**
	 * 
	 * @param start
	 * @param middle
	 * @param end
	 */
	public static void Merge(int start, int middle, int end){
		for(int i= start; i<=end;i++){
			output[i] = input[i];
		}
		int i= start;
		int j = middle+1;
		int k = start;
		
		while(i<=middle && j<=end){
			if(output[i] <= output[j]){
				input[k] = output[i];
				i++;
			}
			else{
				input[k] = output[j];
				j++;
			}
			k++;
		}
		while(i<=middle){
			input[k] = output[i];
			k++;
			i++;
		}
	}
}
