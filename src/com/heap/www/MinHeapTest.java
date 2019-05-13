package com.heap.www;
/**
 * 
 * @author singhbir
 *
 */
public class MinHeapTest {

	public static int[] input;
	public static int len;
	
	public static void main(String[] args){
		input = new int[]{1,7,9,13,15,17,2,3,6,4,23,10,11,12,14,16};
		len = input.length;
		
		//display the initial array
		for(int i=0;i<len;i++){
			System.out.print(input[i]+" ");
		}
		System.out.println();
		while(len > 0)
		{
			for(int i=len/2;i>=0;i--){
				CreateMinHeap(i);
			}
			Swap(0,len-1);
			len--;
		}
		//display the modified array
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
	}
	
	/**
	 * @param index
	 */
	public static void CreateMinHeap(int index){
		int left = 2*index+1;
		int right = 2*index+2;
		int smallest = index;
		
		if(left < len && input[left]<input[smallest]){
			smallest = left;
		}
		if(right < len && input[right]< input[smallest]){
			smallest = right;
		}
		if(smallest != index){
			Swap(index, smallest);
			CreateMinHeap(smallest);
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
