package com.goldman.interview;

import java.util.Arrays;

public class FibSearchTest {

	public static void main(String[] args){
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int search = 7;
		int len = input.length;
		int index = -1;
		boolean found = false;
		Arrays.sort(input);
		
		int first = 0;
		int second = 1;
		
		//array index starts from 0, instead of 1. hence substract 1
		int fib_int = first+second -1;
		int start = 0;
		System.out.println(first+" "+second+" "+fib_int);
		while(true)
		{
			// if the num is found
			if(input[fib_int] == search)
			{
				index = fib_int;
				found = true;
				break;
			}
			else if(input[fib_int] > search)
			{
				start = first;
				first = 0;
				second = 0;
				fib_int = start+first+second-1;
				
			}
			else if(input[fib_int] < search)
			{
				int temp = first;
				first = second;
				second = second+temp;
				fib_int = first;
				System.out.println(first+" "+second+" "+fib_int);
				if(fib_int >= len)
				{
					start = first;
					first = 0;
					second = 1;
					fib_int = start+first+second-1;
				}
			}
		}
		
		if(found)
			System.out.println("found at index:"+index);
	}
}
