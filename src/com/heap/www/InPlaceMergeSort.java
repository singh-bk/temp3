package com.heap.www;

public class InPlaceMergeSort {

	private static int[] input = {3,4,1,2,7,8,9,22,2,5,11,6,12,1,2,10};
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
		
		int mm = middle;
		for(int y=middle+1;y<=end;y++){
			int yy =y;
			for(int x=mm;x>=start;x--){
				if(input[x] > input[yy]){
					swap(x, yy);
					yy = x;
					if(mm<y){
						mm=y;
					}
				}else{
					int xx= 1;//dummy code
					break;
				}
			}
		}
	}
	
	public static void swap(int x, int y){
		int temp = input[x];
		input[x] = input[y];
		input[y] = temp;
	}
}
