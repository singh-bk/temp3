package com.olacabs.www;

public class DiamondTest {

	public static void main(String[] args){
		int[] input = {10,3,1,2,5,6,8,9,11,13};
		int len = input.length;
		int[] output = new int[len];
		output[0] = input[0];
		int level = 1;
		int parentMin = 0, parentMax =0;
		for(int i=1;i<len;){
			int currentMin = parentMax+1;
			int currentMax =  currentMin+level;
			//System.out.println(currentMin+" "+currentMax+" ");
			int temp = 0;
			if(i==currentMin){
				output[i] = output[parentMin]+input[i];
				i++;
			}
			else if(i==currentMax){
				output[i] = output[parentMax]+input[i];
				i++;
				parentMin = parentMax+1;
				parentMax = parentMin+level;
				level++;
			}
			else{
				output[i] = input[i]+Math.min(output[parentMin+temp], output[parentMin+temp+1]);
				temp++;
				i++;
			}
		}
		for(int i=0;i<len;i++)
			System.out.print(output[i]+" ");
	}
	
	
}
