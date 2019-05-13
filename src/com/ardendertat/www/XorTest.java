package com.ardendertat.www;

public class XorTest {

	public static void main(String[] args){
		int[] input = {1,1,1,1,2,2,2,2,3,3,4,4,4,4,5,5,5,5,66,66,66,66,67};
		int output = input[0];
		for(int i=1;i<input.length;i++){
			output = output^input[i];
		}
		System.out.println(output);
	}
}
