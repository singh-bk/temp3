package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SquareDetectorTest2 {

	public static void main(String[] args) throws IOException{
		
		File file = new File("square.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noOfTestCases = 0;
		String str = br.readLine();
		
		//create a double dimensional array
		
		noOfTestCases = Integer.parseInt(str);
		//populate the array
		for(int i=0;i<noOfTestCases;i++){
			boolean isSquare = true;
			
			int squareCount = Integer.parseInt(br.readLine());
			int[][] arr = new int[squareCount][squareCount];
			for(int j=0;j<squareCount;j++){
				boolean hasHashbefore = false;
				char[] charArray = br.readLine().toCharArray();
				for(int k=0;k<charArray.length;k++)
				{
					if(charArray[k]=='#'){
						arr[j][k] = 1;
						if(hasHashbefore){
							isSquare= false;
						}
					}
					if(k>0&& charArray[k-1]=='#' && charArray[k]!='#'){
						hasHashbefore= true;
					}
				}
			}
			
			int[] length = new int[arr.length];
			int[] start = new int[arr.length];
			int[] end = new int[arr.length];
			for(int l=0;l<arr.length;l++){
				start[l] = -1;
				end[l] = -1;
			}
			for(int k=0;k<arr.length;k++){
				for(int j=0;j<arr[k].length;j++){
					length[k] = length[k]+arr[k][j];
					if(arr[k][j]==1){
						if(start[k] == -1){
							start[k] = j;
							end[k] = j;
						}
						else{
							end[k] = j;
						}
					}
				}
				
			}
			
			//we have length[], start[] and end for each line
			
			for(int k=0;k<arr.length;k++){
				for(int j=0;j<arr[k].length;j++){
					System.out.print(arr[k][j]+" ");
				}
				System.out.println(length[k]+" "+start[k]+" "+end[k]);
			}
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
			System.out.println(isSquare && isLengthValid);
		}
		

	}
}
