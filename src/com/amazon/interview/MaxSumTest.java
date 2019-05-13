package com.amazon.interview;

public class MaxSumTest {

	public static void main(String[] args){
		//int[] input = {-7,1,2,9,7,-9,11,13,0,1,-5,6,-8,5,7};
		//int[] input = {-7,-1,-2,-9,-7,-9,-11,-13,0,-1,-5,-6,-8,-5,-7};
		int[] input = {2, -5, 6, -2, -3, 1, 5, -6};
		
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int i=0;i<input.length;i++){
			max_ending_here = max_ending_here + input[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		System.out.println(max_so_far);
	}
}
