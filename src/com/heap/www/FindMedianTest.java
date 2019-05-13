package com.heap.www;

import java.util.Arrays;

/**
 * 
 * @author singhbir
 *
 */
public class FindMedianTest {
	
	static int[] minHeap;
	static int[] maxHeap;
	static int lenOfHeaps;

	public static void main(String[] args){
		int[] input = {11,17,13,45,1,23,89,7};
		int maxMemory = 4;
		lenOfHeaps = maxMemory+1;// original length of heaps or max limit allowed
		/*
		 * the max amount of number that you can store is n(8).
		 * sort the first n(8) numbers of the input.
		 */
		Arrays.sort(input);//nlogn
		maxHeap = new int[lenOfHeaps];
		minHeap = new int[lenOfHeaps];
		for(int i=0;i<maxMemory;i++){
			maxHeap[i] = input[maxMemory-1-i];
			maxHeap[lenOfHeaps -1] = -1; //indicates an emptyspace in the heap
			minHeap[i] = input[i+maxMemory];
			minHeap[lenOfHeaps -1] = -1; // indicates an empty space in the heap.
		}
		for(int i=0;i<maxHeap.length;i++)
			System.out.print(maxHeap[i]+ " ");
		System.out.println();
		for(int i=0;i<minHeap.length;i++)
			System.out.print(minHeap[i]+ " ");
		
		int lenMax = maxHeap.length;//current len of the heap
		int lenMin = minHeap.length;// current len of the heap
		
		int number = 20;
		/*
		 * if the new number is less than first element of minHeap
		 * 	increase the length of minHeap by 1.
		 * 	set this as the last element of the min heap 
		 * 		and re-run the maintain heap process.
		 * 	delete the last element of the min heap(set it to -1)
		 * 	
		 */
		if(number < minHeap[0])
		{
			lenMin++;
			minHeap[lenOfHeaps -1] = number;
			MaintainMinHeap(lenOfHeaps/2);
			minHeap[lenOfHeaps -1] = -1;
		}
		/*
		 * 	increase the length of maxHeap by 1.
		 * 	set this as the last element of the max heap 
		 * 		and re-run the maintain heap process.
		 * 	delete the last element of the max heap(set it to -1).
		 */
		else 
		{
			lenMax++;
			maxHeap[lenOfHeaps -1] = number;
			MaintainMaxHeap(lenOfHeaps/2);
			maxHeap[lenOfHeaps -1] = -1;
		}
		System.out.println("====================================");
		for(int i=0;i<maxHeap.length;i++)
			System.out.print(maxHeap[i]+ " ");
		System.out.println();
		for(int i=0;i<minHeap.length;i++)
			System.out.print(minHeap[i]+ " ");
		
	}
	
	/**
	 * MinHeap stores data from larger to smaller
	 * @param index
	 */
	public static void MaintainMinHeap(int index){
		int left = 2*index+1;
		int right = 2*index+2;
		int largest = index;
		
		if(left<lenOfHeaps && minHeap[left] != -1 && minHeap[left] > minHeap[largest]){
			largest = left;
		}
		if(right<lenOfHeaps && minHeap[right] != -1 && minHeap[right] > minHeap[largest]){
			largest = right;
		}
		if(largest != index){
			SwapMinHeap(index, largest);
			MaintainMinHeap(largest);
		}
	}
	
	/**
	 * @param index1
	 * @param index2
	 */
	public static void SwapMinHeap(int index1, int index2){
		int temp = minHeap[index1];
		minHeap[index1] = minHeap[index2];
		minHeap[index2] = temp;
	}
	
	/**
	 * MaxHeap stores data from smaller to largest
	 * @param index
	 */
	public static void MaintainMaxHeap(int index){
		int left = 2*index+1;
		int right = 2*index+2;
		int smallest = index;
		
		if(left<lenOfHeaps && maxHeap[left] != -1 && maxHeap[left] < minHeap[smallest]){
			smallest = left;
		}
		if(right<lenOfHeaps && maxHeap[right] != -1 && maxHeap[right] < maxHeap[smallest]){
			smallest = right;
		}
		if(smallest != index){
			SwapMaxHeap(index, smallest);
			MaintainMaxHeap(smallest);
		}
	}
	
	/**
	 * @param index1
	 * @param index2
	 */
	public static void SwapMaxHeap(int index1, int index2){
		int temp = maxHeap[index1];
		maxHeap[index1] = maxHeap[index2];
		maxHeap[index2] = temp;
	}

}
