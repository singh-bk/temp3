package com.flipkart.www;

import java.util.Arrays;
import java.util.List;


/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 * @author bk
 *
 */
public class WordBreakTest {

	public static void main(String... args){
		String[] input = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
				  "cream", "icecream", "man", "go", "mango"};
		List<String> inputs = Arrays.asList(input);
		String word = "ilikesamsung";
		char[] words = word.toCharArray();
		int len = word.length();
		int max = (len*(len+1))/2;
		String[] segments = new String[max];
		
		int index = 0;
		for(int i=0;i<len;i++){
			int start = index;
			for(int j=0;j<=i;j++){
				segments[index] = word.substring(j, len+j-i);
				System.out.print(segments[index]+",");
				index++;
			}
			int end = index;
			boolean found = true;
			for(int xx= start; xx<=end;xx++){
				found = found & inputs.contains(segments[xx]);
				if(!found)
					break;
			}
			System.out.println();
		}
	}
}
