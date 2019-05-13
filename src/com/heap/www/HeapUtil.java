package com.heap.www;

public class HeapUtil {

	private static int[] input;
	private static int len;
	
	/**
	 * @param input
	 */
	public static void BuildMaxHeap(int[] input){
		len = input.length-1;
		for(int i=len/2;i>=0;i--){
			MaxHeap(input, i);
		}
	}
	
	/**
	 * This method ensures that the child nodes are less than the parent node;
	 * @param input
	 * @param index
	 */
	public static void MaxHeap(int[] input, int index){
		int left = 2*index;
		int right = 2*index+1;
		int largest;
		if(left<=len && input[left] > input[index]){
			largest = left;
		}
		else{
			largest = index;
		}
		if( right<=len && input[right] > input[largest]){
			largest = right;
		}
		if(largest != index){
			Exchange(largest, index);
			MaxHeap(input, largest);
		}
	}
	
	/**
	 * @param i
	 * @param j
	 */
	public static void Exchange(int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void HeapSort(int[] arr){
		input = arr;
		BuildMaxHeap(input);
		for(int i=len;i>0;i--){ 
            Exchange(0, i); 
            len=len-1; 
            MaxHeap(input, 0); 
        } 
	}
	
	public static void main(String[] args){
		input = new int[]{1,6,7,2,3,9,11,5,23,14,4};
		HeapSort(input);
		for(int i=0;i<input.length;i++)
			System.out.print(input[i]+" ");
	}
		
}
