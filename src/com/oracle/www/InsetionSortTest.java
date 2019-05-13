package com.oracle.www;

import java.util.Arrays;

public class InsetionSortTest {

	public static void main(String[] args){
		//int[] input = {4,5,6,1,2,3,9,7,10,8};

		int[] input = {9,8,7,6,5,4,3,2,1,0};
		int len = input.length;
		System.out.println(len);
		int count = 0;
		for(int i=1;i<len;i++){
			count++;
			int j = i-1;
			int key = input[i];
			while(j>=0 && input[j] > key){
				count++;
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
		}
		
		System.out.println(Arrays.toString(input));
		System.out.println(count);
	}
	
	
}
