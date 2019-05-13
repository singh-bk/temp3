package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PixelTest {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("pixel.txt")));
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCaseCount;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str," ");
			int width = Integer.parseInt(token.nextToken());
			int height = Integer.parseInt(token.nextToken());
			int picWidth = Integer.parseInt(token.nextToken());
			int picHeight = Integer.parseInt(token.nextToken());
			int deadPixelCount = Integer.parseInt(token.nextToken());
			int X = Integer.parseInt(token.nextToken());
			int Y = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			
			//create a matrix of size width x height and initialize all elements to 0.
			int[][] matrix = new int[height][width];
			//get all the dead pixels - initialize the var to -1(no such index in matrix)
			int[] deadRowIndex = new int[deadPixelCount];
			int[] deadColIndex = new int[deadPixelCount];
			deadRowIndex[0] = Y;
			deadColIndex[0] = X;
			//set dead pixel position in matrix to -1
			matrix[deadRowIndex[0]][deadColIndex[0]] = -1;
			for(int j=1;j<deadPixelCount;j++){
				deadColIndex[j] = ((deadColIndex[j - 1] * a + deadRowIndex[j - 1] * b + 1) % width);
				deadRowIndex[j] = ((deadColIndex[j - 1] * c + deadRowIndex[j - 1] * d + 1) % height);
				//set dead pixel position in matrix to -1
				matrix[deadRowIndex[j]][deadColIndex[j]] = -1;
			}
			
			/*
			 * 1. Iterate over the matrix
			 */
			int count = 0;
			int maxWidthIndex = width - picWidth;
			int maxHeightIndex = height - picHeight;
			
			for(int widthIndex=0;widthIndex<=maxWidthIndex;widthIndex++){
				for(int heightIndex = 0; heightIndex<=maxHeightIndex;heightIndex++){
					int pixelWidthIndex = widthIndex+picWidth-1;
					int pixelHeightIndex = heightIndex+picHeight-1;
					boolean isValid = true;
					if(pixelWidthIndex<width && pixelHeightIndex<height)
					{
						for(int kk=heightIndex;kk<=pixelHeightIndex;kk++)
						{
							for(int jj=widthIndex;jj<=pixelWidthIndex;jj++)
							{
								if(matrix[kk][jj] == -1)	
								{
									isValid = false;
									break;
								}
							}
							if(!isValid)
								break;
						}
						if(isValid)
						{
							count++;
						}
					}

				}
			}
			
			System.out.println("Case "+(i+1)+":"+count);
		}
	}
}
