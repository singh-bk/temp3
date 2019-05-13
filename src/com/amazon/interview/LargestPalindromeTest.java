package com.amazon.interview;

public class LargestPalindromeTest {

	public static void main(String[] args){
		String input = "pmpmpmetabccbatemp";
		PrintLargestPalindrome(input);
	}
	
	/**
	 * @param input
	 */
	public static void PrintLargestPalindrome(String input){
		int len = input.length();
		char[] chars = input.toCharArray();
		
		/*
		 * isPalindrome[i][j] indicates that string between i to j is a palindrome
		 * default value for boolean is false
		 * all sub strings of length one is a palindrome - make it true
		 * check  for substrings of length 2 - make true wherever you find a palindrome
		 * 		two chars are equal
		 */
		boolean isPalindrome[][] = new boolean[len][len];
		//for substring of length 1.
		int j = 0;
		for(int i=0;i<len-j;i++){
			isPalindrome[i][i] = true;
		}
		//for substring of length 2
		j = 1;
		int start = 0; // start of palindrome substring
		int maxlen = 0; // max len of the palindrome substring
		for(int i=0;i<len-j;i++){
			if(chars[i] == chars[i+1]){
				isPalindrome[i][i+1] = true;
				start = i;
				maxlen= 2;
			}
		}
		//for substring of length 3 to length of the string
		for(int k=3; k<=len;k++)
		{
			j = k-1;
			for(int i=0;i<len-j;i++)
			{
				int l = i+j;
				if(isPalindrome[i+1][l-1] && chars[i] == chars[l])
				{
					isPalindrome[i][l] = true;
					if(k > maxlen){
						maxlen = k;
						start = i;
					}
				}
			}
		}

		System.out.println(maxlen+" "+input.substring(start, (start+maxlen)));
	}
}
