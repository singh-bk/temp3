package com.walmart.www;

public class MaxSumTest {

	public static void main(String[] args) {
		int[] input = {3,2,7,10};
		int len = input.length;
		
		
		int[] with = new int[len];
		int[] wo = new int[len];
		int max = 0;
		
		with[0] = input[0];
		wo[0] = 0;
		max = input[0];
		
		for(int i=1;i<len;i++){
			int num = input[i];
			with[i] = num+wo[i-1];
			wo[i] = Math.max(with[i-1],wo[i-1]);
		
			max = Math.max(with[i], wo[i]);
		}
		
		System.out.println(max);
	}
}
