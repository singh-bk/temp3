package com.twitter.www;

/**
 * http://www.geeksforgeeks.org/twitter-interview-set-1/
 * @author Birendra Kumar Singh
 *
 */
public class RemoveDuplicatesTest {

	public static void main(String[] args){
		int[] input = {1,5,2,6,8,9,1,1,10,3,2,4,1,3,11,3};
		int count = 0;
		for(int i=0;i<input.length;i++){
			while(input[i] != i && input[i]!=-1){
				count++;
				int num = input[i];
				if(num != i && num != input[num]){
					int temp = input[num];
					input[num] = num;
					input[i] = temp;
				}
				else if(num != i && num == input[num])
				{
					input[i] = -1;
				}
			}
		}
		for(int i=0;i<input.length;i++)
			System.out.print(input[i]+" ");
		System.out.println(count++);
	}
}
