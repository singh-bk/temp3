package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SquareDetectorTest3 {

	public static void main(String[] args) throws IOException{
		
		File file = new File("square.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noOfTestCases = 0;
		String str = br.readLine();
		
		
		noOfTestCases = Integer.parseInt(str);
		for(int i=0;i<noOfTestCases;i++)
		{
			boolean isSquare = true;
			int squareCount = Integer.parseInt(br.readLine());
			
			int length = 0; 
			int start = -1; 
			int end = -1;  
			int decreasingLength = 0;
			
			//Read the matrix - line by line
			for(int j=0;j<squareCount;j++)
			{
				int currentLength = 0;
				int currentStart = -1;
				int currentEnd = -1;
				boolean hasHashbeforeADot = false;
				//Read all matrix - char by char
				char[] charArray = br.readLine().toCharArray();
				for(int k=0;k<charArray.length;k++)
				{
					if(charArray[k]=='#')
					{
						if(hasHashbeforeADot)
						{
							//Not a perfect square - break;
							isSquare= false;
							break;
						}
						if(currentStart == -1)
						{
							currentStart = k; if(start == -1){start = k;}
							currentEnd = k; if(end == -1){end = k;}
							currentLength++; if(length == 0){length = currentLength;}
						}
						//Else, we have encountered # in the same row.
						else
						{
							currentEnd = k;
							currentLength++;
						}
					
					}
					if(k>0&& charArray[k-1]=='#' && charArray[k]!='#'){
						hasHashbeforeADot= true;
					}
				}
				if(decreasingLength == 0 && currentLength > 0){
					decreasingLength = currentLength;
				}
				else if(decreasingLength != 0 && currentLength > 0){
					decreasingLength--;
				}
				
				/**
				 * 
				 */
				if(currentLength != length || start != currentStart || end != currentEnd)
				{
					isSquare = false;
				}
			}
			System.out.println(isSquare);
		}
		

	}
}
