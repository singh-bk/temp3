package com.hp.util;

public class RetailPatternMatcher {

	public static void main(String[] args){
		String message = "Rs. 1,55,425.62 was spent on your Credit Card 5546xxxxxxxx1460 on 21-07 as SHOPPERS STOP.";
		
		int index = message.indexOf("at");
		int index2 = message.indexOf(".");
		while (index2 >= 0 && index2<index) {
		    //System.out.println(index2);
		    index2 = message.indexOf(".", index2 + 1);
		}
		System.out.println(index);
		System.out.println(index2);
		System.out.println(message.substring(index+3, index2));
	}
}
