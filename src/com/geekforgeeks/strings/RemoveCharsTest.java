package com.geekforgeeks.strings;
/**
 * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
 * @author singhbir
 *
 */
public class RemoveCharsTest {

	private static char[] chars;
	public static void main(String[] args){
		String input = "ababac";
		chars = input.toCharArray();
		char str1 = 'b';
		String str2 = "ac";
		int len = RemoveChars(str1, str2);
		for(int i=0;i<=len;i++)
			System.out.print(chars[i]+" ");
	}
	/**
	 * 
	 * @param input
	 */
	private static int RemoveChars(char str1, String str2){
		
		int index1 = 0; // to maintain the count of chars after alteration
		int index2 = 0; // to maintain the count of str2Char after alteration
		char[] str2Char = str2.toCharArray();
		for(int i=0;i<chars.length;i++)
		{
			//check for the first char
			if(chars[i] == str1){
				//No change in index1; i will be incremented
				// make sure to change index2 to zero if it is not.
				if(index2!=0){
					index1 = index1+index2;
					index2 = 0;
				}
			}
			//check for the 2nd string
			else if(index2<str2Char.length && chars[i] == str2Char[index2]){
					index2++;
			}
			//no match found. increase the count of index.
			//replace the char at index1 with char at i.
			else
			{
				if(index2!=0 && index2!=str2.length())
				{
					index1 = index1+index2;
					index2=0;
				}
				if(i!=index1)
				{
					chars[index1] = chars[i];
				}
				index1++;
			}//end else
		}//end for\
		System.out.println(index1-1);
		return index1-1;
	}
}
