package com.string.geeksforgeeks;

public class InterleavedTest {

	public static void main(String[] args){
		String str1 = "XXXY";
		String str2 = "XXXZ";
		String testStr = "XXXYXXXZ";
		
		int len1 = str1.length();
		int len2 = str2.length();
		int len = testStr.length();
		int ref1 = 0;
		int ref2 = 0;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		char[] test = testStr.toCharArray();
		int count = 0;
		while(count < len){
			if(chars1[ref1] == test[count]){
				ref1++;
			}
			else{
				ref1 = -1;
			}
			if(chars2[ref2] == test[count]){
				ref2++;
			}
			else{
				ref2 = -1;
			}
			count++;
		}
	}
}
