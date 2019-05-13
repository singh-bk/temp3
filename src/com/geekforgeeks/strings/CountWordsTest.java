package com.geekforgeeks.strings;

import java.util.LinkedList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/count-words-in-a-given-string/
 * @author singhbir
 *
 */
public class CountWordsTest {

	public static void main(String[] args){
		String input = "     Count     Words       in a given string              !        ";
		char[] inputArr = input.toCharArray();
		List<String> words =CountWords(inputArr,' '); 
		for(int i=0;i<words.size();i++){
			System.out.print(words.get(i)+" ");
		}
	}
	
	/**
	 * @param inputArr
	 * @return
	 */
	public static List<String> CountWords(char[] inputArr, char seperator){
		List<String> words = new LinkedList<String>();
		int start = 0;
		int end = 0;
		int count = 0;
		int prevCount = 0;
		boolean hasWordBefore = false;
		for(int i=0;i<inputArr.length;i++){
			if(inputArr[i] == seperator)
			{
				if(hasWordBefore)
				{
					end = i-1;
					count++;
					hasWordBefore = false;
				}
				else
				{
					start = i+1;
					end = i+1;
				}
			}
			else 
			{
				if(!hasWordBefore){
					start = i;
					hasWordBefore = true;
				}
				//else condition is not needed
			}
			
			if(count > prevCount)
			{
				StringBuffer str = new StringBuffer("");
				for(int k=start;k<=end;k++){
					str.append(inputArr[k]);
				}
				words.add(str.toString());
				prevCount++;
			}
		}
		System.out.println(count);
		return words;
	}
}
