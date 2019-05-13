package com.amazon.interview;

public class BinarySearchTest {

	public static void main(String[] args){
		int[] input = {1,2,3,5,6,7,8,9,10,11,12,13,15,16,17,18,19,20,21,22,23,25,26};
		boolean found = BinarySearch(input, 13,0,input.length-1);
		System.out.println(found);
	}
	
	public static boolean BinarySearch(int[] input, int search, int min, int max){
		boolean found = false;
		if(search == input[min] || search == input[max]){
			found = true;
		}
		else if(search < input[min] || search > input[max]){
			found = false;
		}
		else if(search == input[(min+max)/2]){
			found = true;
		}
		else if(search > input[(min+max)/2]){
			found = BinarySearch(input, search, ((min+max)/2)+1, max);
		}
		else if(search < input[(min+max)/2]){
			found = BinarySearch(input, search, min, ((min+max)/2)-1);
		}
		return found;
	}
}
