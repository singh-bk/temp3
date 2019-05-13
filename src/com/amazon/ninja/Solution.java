package com.amazon.ninja;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader(new File("segment.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count2 = Integer.parseInt(br.readLine());
		String[] str = new String[count2];
		for(int i=0;i<str.length;i++){
			str[i] = br.readLine().trim();
		}
		str = RemoveDuplicates(str);
		input = input.replaceAll("[^A-Za-z ]", "");
		StringTokenizer token = new StringTokenizer(input, " ");
		
		/*
		 * arr contains the index of all the elements
		 * strArr contains the actual string
		 */
		int[] arr = new int[token.countTokens()];
		String[] strArr = new String[token.countTokens()];
		for(int i=0;i<arr.length;i++){
			arr[i] = -1;
		}
		int count = 0;
		while(token.hasMoreTokens())
		{
			String temp = token.nextToken();
			strArr[count] = temp;
			for(int j=0;j<str.length;j++)
			{
				if(temp.equalsIgnoreCase(str[j]))
				{
					//when a match is found. update the index of the match in the array. 
					arr[count] = j;
				}
			}
			count++;
		}
		
		int[] occurenceIndex = new int[str.length];
		int lastLen = -1;
		int currentLen = -1;
		int min = -1;
		int max = -1;
		for(int i=0;i<occurenceIndex.length;i++){
			occurenceIndex[i] = -1;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] != -1)
			{
				/*
				 * 1. get the index from the arr
				 * 2. populate the occurenceIndex for the given index.
				 * 3. Check if all elements of occurenceIndex > -1
				 * 		if yes, calculate the length of the occurenceIndex
				 * 				get the max and min - currentLen = max-min.
				 * 				if lastLen = 0 or lastLen > currentLen
				 * 					lastLen = currentLen
				 */
				int index = arr[i];
				occurenceIndex[index] = i;
				boolean isNotEmpty = IsNotEmpty(occurenceIndex);
				if(isNotEmpty)
				{
					int[] minmax = GetMinMaxFromArray(occurenceIndex);
					currentLen = minmax[1] - minmax[0];
					if(lastLen <0 || lastLen > currentLen)
					{
						lastLen = currentLen;
						min = minmax[0];
						max = minmax[1];
					}
				}
			}
		}
		if(min>-1 && max>-1 && max>=min)
		{
			for(int i=min;i<=max;i++)
			{
				System.out.print(strArr[i]+" ");
			}
		}
		else
		{
			System.out.println("NO SUBSEGMENT FOUND");
		}
		
	}
	
	/**
	 * @param arr
	 * @return
	 */
	public static boolean IsNotEmpty(int[] occurenceIndex)
	{
		boolean isNotEmpty = true;
		for(int i=0;i<occurenceIndex.length;i++){
			if(occurenceIndex[i] == -1)
				isNotEmpty = false;
		}
		return isNotEmpty;
	}
	
	/**
	 * @param arr
	 * @return
	 */
	public static int[] GetMinMaxFromArray(int[] occurenceIndex)
	{
		int min = occurenceIndex[0];
		int max = occurenceIndex[0];
		if(occurenceIndex.length>1)
		{
			for(int i=1;i<occurenceIndex.length;i++)
			{
				if(occurenceIndex[i]<min){
					min = occurenceIndex[i];
				}
				if(occurenceIndex[i] > max){
					max = occurenceIndex[i];
				}
			}
		}
		return new int[]{min,max};
	}
	
	public static String[] RemoveDuplicates(String[] input)
	{
		   List<String> noDuplicates = new ArrayList<String>();
		    for (String arrayElem : input) {
		        if (!noDuplicates.contains(arrayElem)) {
		            noDuplicates.add(arrayElem);
		        }
		    }
		    return (String[]) noDuplicates.toArray(new String[0]);
	}

}
