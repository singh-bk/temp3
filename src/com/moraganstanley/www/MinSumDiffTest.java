package com.moraganstanley.www;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumDiffTest {

	public static void main(String[] args){
		int[] input = {1,11,2,12,3,4,14,5,6,13,7,8,9,15,10};
		int len = input.length;
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		int sum = 0;
		for(int i=0;i<len;i++){
			sum = sum+input[i];
		}
		System.out.println(sum);
		
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();

		int sum1 = input[len-1];
		int sum2 = input[len-2];
		int diff = 0;
		if(sum1 - sum2 >= 0) diff = sum1-sum2;
		else diff = sum2-sum1;
		
		one.add(input[len-1]);
		two.add(input[len-2]);
		
		for(int i=len-3;i>=0;i--){
			int temp = input[i];
			int diff1 = 0;
			if(sum1+temp-sum2 >= 0) diff1 = sum1+temp-sum2;
			else diff1 = sum2-(sum1+temp);
			
			int diff2 = 0;
			if(sum2+temp-sum1 >=0) diff2 = sum2+temp-sum1;
			else diff2 = sum1-(temp+sum2);
			
			if(diff1>=diff2){
				one.add(temp);
				sum1 = sum1+temp;
			}
			else{
				two.add(temp);
				sum2 = sum2+temp;
			}
			
		}
		
		int num1 = 0; int num2 = 0;
		for(int i=0;i<one.size();i++)
			num1 = num1+one.get(i);
		for(int i=0;i<two.size();i++)
			num2 = num2+two.get(i);
		
		System.out.println(num1-num2);
	}
}
