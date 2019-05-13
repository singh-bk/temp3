package com.amazon.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AlphabetTest {

	public static void main(String[] args)
	{
		try
		{
			FileReader fr = new FileReader(".\\input.txt");
			BufferedReader br = new BufferedReader(fr);
			String inputStr  = null;
			
			while((inputStr = br.readLine()) != null)
			{
				Hashtable hashtable = new Hashtable();
				int count = 0;
				for(int i=0;i<inputStr.length();i++)
				{
					char character = inputStr.charAt(i);
					System.out.print(character);
					if(hashtable.get(character) != null)
					{
						count = (Integer)hashtable.get(character);
						hashtable.put(character, ++count);
					}
					else
					{
						hashtable.put(character, 1);
					}

				}
				Set set = hashtable.entrySet();
				Iterator iter = set.iterator();
				int max=0;
				String maxChar=null;
				while(iter.hasNext())
				{
					Map.Entry entry = (Map.Entry)iter.next();
					if(Integer.parseInt(entry.getValue().toString()) >= max && !entry.getKey().toString().equals(" "))
					{
						if(Integer.parseInt(entry.getValue().toString()) > max)
						{
							maxChar = entry.getKey().toString();
						}
						else
						{
							maxChar = maxChar+entry.getKey().toString();
						}
						max= Integer.parseInt(entry.getValue().toString());
					}
				}
				System.out.println("max:"+max);
				System.out.println("maxChar:"+maxChar);
				System.out.println();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
