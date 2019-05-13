package com.heap.www;

/**
 * @author singhbir
 *
 */
public class MaxHeapTest {

	//the input array
	static int[] input;
	//length of the inpout array
	static int len;
	
	public static void main(String[] args){
		input = new int[]{1,7,9,13,15,17,2,3,6,4,23,10,11,12,14,16};
		len = input.length;
		//display the initial array
		for(int i=0;i<len;i++){
			System.out.print(input[i]+" ");
		}
		System.out.println();
		//create the heap
		while(len > 0)
		{
			for(int i=len/2;i>=0;i--){
				CreateMaxHeap(i);
			}
			/*
			 * input[0] will have the largest element
			 * swap input[0] and input[len-1].
			 * and run the process again
			 */
			Swap(0, len-1);
			len--;
		}
		//display the new sorted array in ascending order
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
	}
	
	/**
	 * @param index
	 */
	public static void CreateMaxHeap(int index){
		int left = 2*index+1;
		int right = 2*index+2;
		int largest = index;
		
		if(left < len && input[left] > input[largest]){
			largest = left;
		}
		if(right < len && input[right] > input[largest]){
			largest = right;
		}
		if(largest != index){
			Swap(index, largest);
			CreateMaxHeap(largest);
		}
	}
	
	/**
	 * @param index1
	 * @param index2
	 */
	public static void Swap(int index1, int index2){
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
