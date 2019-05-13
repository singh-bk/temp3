package com.flipkart.www;

public class StringCompressionTest {

	public static void main(String[] args){
		String str = "zaaaabbbbbccccc\0";
		char[] input = str.toCharArray();
		input = ReplaceCharacters(input);
		System.out.println(input);
	}
	
	public static char[] ReplaceCharacters(char[] input){ 
		int ipIndex = 1;
		int opIndex = 1;
		boolean isNewElement = false;
		int prev = input[0];
		int count = 1;
		while(input[ipIndex] != '\0'){
			
			char ch = input[ipIndex];
			if(isNewElement){
				input[opIndex] = ch;
				opIndex++;
				isNewElement = false;
			}
			if(ch == prev){
				count++;
			}else{
				if(count == 1){
					input[opIndex] = ch;
					opIndex++;
				}else{
					input[opIndex] = (char) (count+48);
					count = 1;
					isNewElement = true;
				}
				opIndex++;
				prev = input[ipIndex];
			}
			ipIndex++;
		}
		if(count>1){
			input[opIndex] = (char)(count+48);
			opIndex++;
			input[opIndex] = '\0';
		}
		return input;
	}
}
