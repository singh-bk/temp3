package com.interviewstreet.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		getDigitsInBook(n);
	}
	
	static void getDigitsInBook(int n) {
		//all initialized to zero.
		int[] count = new int[10];
		
		for(int i=1;i<=n;i++)
		{
			String  str = String.valueOf(i);
			//System.out.println(str);
			int start = 0;;
			int end = 1;
			while(end<=str.length())
			{
				String temp = str.substring(start, end);
				start = end;
				end = end+1;
				count[Integer.parseInt(temp)]++;
				//System.out.println(temp);
			}
		}
		
		for(int i=0;i<count.length;i++)
		{
			System.out.println(count[i]);
		}
	}
}
