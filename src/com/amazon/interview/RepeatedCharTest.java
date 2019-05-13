package com.amazon.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedCharTest {

	public static void main(String[] args){
		String input = "aaaabbbbcccc";
		char[] chars = input.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<chars.length;i++){
			if(map.get(chars[i]) != null){
				int count = map.get(chars[i]);
				map.put(chars[i], ++count);
			}
			else
			{
				map.put(chars[i], 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		Iterator iter = entrySet.iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)iter.next();
			char key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key+""+value);
		}
		
		int count =1;
		char temp = chars[0];
		StringBuffer output = new StringBuffer();
		for(int i=1;i<chars.length;i++){
			if(chars[i] == temp)
				count++;
			else{
				output.append(count+""+temp);
				count = 1;
				temp = chars[i];
			}
		}
		output.append(count+""+temp);
		System.out.println(output);
	}
}
