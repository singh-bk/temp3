package com.ardendertat.www;

public class AllPermutationsTest {

	public static void main(String[] args){
		String input = "Birendra";
		
	}
	
	public static String GetAllPermutations(String input){
		if(input.length() == 1)
			return input;
		String temp = GetAllPermutations(input.substring(1,input.length()));
		char first = input.toCharArray()[0];
		char[] result = {};
		
		for(int i=0;i<temp.length();i++){
			
		}
	}
}
