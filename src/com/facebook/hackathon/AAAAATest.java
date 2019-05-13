package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AAAAATest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));
		int testCaseCount = Integer.parseInt(br.readLine());
		for(int i=0;i<testCaseCount;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			int rowCount = Integer.parseInt(token.nextToken());
			int colCount = Integer.parseInt(token.nextToken());
			// prepare the input
			int[][] input = new int[rowCount][colCount];
			for(int j=0;j<rowCount;j++)
			{
				char[] inputRow = br.readLine().toCharArray();
				for(int k=0;k<inputRow.length;k++)
				{
					if(inputRow[k]=='.')
					{
						input[j][k] = 1;
					}
					else if(inputRow[k]=='#')
					{
						input[j][k] = 0;
					}
				}
			}
			
			boolean hasTraversedLeftOrUp = false;
			int currentLength = 0;
			int maxLength = 0;
			int currentRowIndex = 0;
			int currentColIndex = 0;
			while(true)
			{
				if(input[currentRowIndex][currentColIndex] == '.')
				{
					currentLength++;
				}
			}
		}
	}
}
