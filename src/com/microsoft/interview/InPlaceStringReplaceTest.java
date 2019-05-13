package com.microsoft.interview;

public class InPlaceStringReplaceTest {

	public static void main(String[] args){
		//String str = "aaaaffffdddddwwwaaaabbbb";
		String str = "gaaaaffffdddddwwwaaaabbbbk";
		ReplaceCharacters(str);
		//String str = "abcdefghijklmnoaabbdd";
	}
	
	public static void ReplaceCharacters(String str)
	{
		char[] input = str.toCharArray();
		System.out.println(input);
		int index = 1;
		int char_index = 0;
		boolean hasEnded = false;
		
		for(int i=1;i<input.length;)
		{
			if(!hasEnded)
			{
				char temp = input[i];
				int count = 1;
				if(temp == input[i-1])
				{
					while(temp == input[i-1])
					{
						count++;
						if(i<input.length-1)
						{
							i++;
							temp = input[i];
						}
						else
						{
							input[index] = (char)count;
							hasEnded = true;
							break;
						}
					}
					input[index] = Character.toChars(count+48)[0];
					index++;
				}
				else
				{
					char_index=i;
					input[index] = input[char_index];
					index++;
					i++;
					
				}
			}
			else
			{
				break;
			}
		}
		System.out.println(index);
		System.out.println(input);

	}
}
