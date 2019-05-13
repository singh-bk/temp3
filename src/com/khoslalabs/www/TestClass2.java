package com.khoslalabs.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class TestClass2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] child = new int[count];
		int sum_laddus = 0;
		for(int i=0;i<count;i++){
			int rating = Integer.parseInt(br.readLine());
			child[i] = rating;
		}
		Arrays.sort(child);
		int[] child2 = new int[count];
		int index2 = 0;
		int start_iteration_count = 0;
		int end_iteration_count = 0;
		
		boolean from_start = true;
		while((start_iteration_count + end_iteration_count) < count){
			if(from_start){
				int temp = child[start_iteration_count];
				int count_nested = 1;
				start_iteration_count++;
				while(child[start_iteration_count] == temp){
					count_nested++;
					start_iteration_count++;
				}
				for(int i=0;i<count_nested;i++){
					child2[index2] = temp;
					index2++;
				}
				from_start = false;
			}
			else{
				int temp = child[count-1 - end_iteration_count];
				int count_nested = 1;
				end_iteration_count++;
				while(child[count-1 - end_iteration_count] == temp){
					count_nested++;
					end_iteration_count++;
				}
				for(int i=0;i<count_nested;i++){
					child2[index2] = temp;
					index2++;
				}
				from_start = true;
			}
			//iteration_count++;
		}
		System.out.println(Arrays.toString(child2));
		int last_laddu = 0;
		for(int i=0;i<count;i++){
			int current_laddu = 1;
			boolean lower_rated_neighbour = false;
			if(i>0 && child2[i] > child2[i-1]){
				lower_rated_neighbour = true;
				current_laddu = last_laddu+1;
			}
			if(!lower_rated_neighbour && i<count-1 && child2[i]>child2[i+1]){
				lower_rated_neighbour = true;
				current_laddu = 2;
			}
			if(!lower_rated_neighbour){
				current_laddu =1;
			}
			
			last_laddu = current_laddu;
			sum_laddus = sum_laddus+current_laddu;
		}
		System.out.println(sum_laddus);
	}
}
