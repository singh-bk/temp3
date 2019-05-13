package com.kaggle.www;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RemoveCommonWordsTest {

	public static void main(String[] args){
		String text = "I would like to do a nice novel about nature AND people people nature would novel novelty";
		Set<String> commonWords = new HashSet<String>();
		commonWords.add("i");
		commonWords.add("to");
		commonWords.add("do");
		commonWords.add("a");
		commonWords.add("and");
		
		HashMap<String, Integer> keywords = new HashMap<String, Integer>(); 
		//Set<String> keywords = new HashSet<String>();
		
		StringBuffer modifiedTxt = new StringBuffer(""); 
		StringTokenizer token = new StringTokenizer(text," ");
		
		while(token.hasMoreTokens()){
			String str = token.nextToken().toLowerCase();
			if(!commonWords.contains(str)){
				modifiedTxt.append(str).append(" ");
				int count = 0;
				if(keywords.get(str) != null)
					count = keywords.get(str);
				keywords.put(str, ++count);
			}
		}
		System.out.println(modifiedTxt);
		System.out.println(keywords.size());
		
		Iterator<Map.Entry<String,Integer>> iter = keywords.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, Integer> entry = iter.next();
			System.out.println("key="+entry.getKey()+" value="+entry.getValue());
		}
		
	}
}
