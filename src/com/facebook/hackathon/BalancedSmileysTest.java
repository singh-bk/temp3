package com.facebook.hackathon;


public class BalancedSmileysTest {

	public static void main(String[] args){
		String input = "i am sick today (:())";
		char[] inputChar = input.toCharArray();
		System.out.println(IsBalancedSmileys(inputChar));
	}
	/**
	 * @param inputChar
	 * @return
	 */
	public static String IsBalancedSmileys(char[] inputChar){
		int len = inputChar.length;
		int minOpen = 0;
		int maxOpen = 0;
		
		for(int i=0;i<len;i++){
			if(inputChar[i] == '(')
			{
				maxOpen++;
				if(i!= 0 && inputChar[i-1] != ':'){
					minOpen++;
				}
			}
			else if(inputChar[i] == ')')
			{
				if(minOpen != 0 )minOpen--;
				if(i!= 0 && inputChar[i-1] != ':'){
					maxOpen--;
					if(maxOpen < 0) break;
				}
			}
		}
		if(maxOpen >=0 && minOpen == 0){
			return "YES";
		}
		else
			return "NO";
	}
}
