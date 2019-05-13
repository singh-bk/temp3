package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SquareDetectorTest {

	public static void main(String[] args) throws IOException{
		
		File file = new File("input.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noOfTestCases = 0;
		String str = br.readLine();
		
		
		noOfTestCases = Integer.parseInt(str);
		for(int i=0;i<noOfTestCases;i++)
		{
			boolean isSquare = true;
			int squareCount = Integer.parseInt(br.readLine());
			
			int[] length = new int[squareCount];
			int[] start = new int[squareCount];
			int[] end = new int[squareCount];
			for(int l=0;l<squareCount;l++){
				start[l] = -1;
				end[l] = -1;
			}
			for(int j=0;j<squareCount;j++){
				boolean hasHashbefore = false;
				char[] charArray = br.readLine().toCharArray();
				for(int k=0;k<charArray.length;k++)
				{
					if(charArray[k]=='#'){
						if(hasHashbefore){
							isSquare= false;
						}
						if(start[j] == -1){
							start[j] = k;
							end[j] = k;
							length[j]++;
						}
						else{
							end[j] = k;
							length[j]++;
						}
					
					}
					if(k>0&& charArray[k-1]=='#' && charArray[k]!='#'){
						hasHashbefore= true;
					}
				}
			}
			
			
			//we have length[], start[] and end for each line
			
			boolean isLengthValid = true;
			boolean hasElement = false;
			int finalLength = 0;
			for(int l=0;l<length.length;l++){
				if(hasElement && length[l] >0){
					if(l>0 && length[l]!=length[l-1]){
						isLengthValid = false;
						break;
					}
					else if(l>0 && length[l]==length[l-1]){
						finalLength--;
					}
				}
				else if(length[l]>0){
					hasElement = true;
					finalLength = length[l];
				}
			}
			//check if start and end index are same
			for(int l=1;l<start.length;l++){
				if(start[l]!=-1 && start[l-1]!=-1 && (start[l]!=start[l-1] || end[l]!=end[l-1])){
					isSquare = false;
				}
			}
			if(finalLength!=1){
				isLengthValid = false;
				isSquare = false;
			}
			String output = "NO";
			if(isSquare && isLengthValid)
				output = "YES";
			System.out.println("CASE #"+(i+1)+": "+output);
		}
		

	}
}
