package com.qwest.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class YogaTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("yoga.txt")));
		String str = br.readLine();
		while(!(str.trim().equals("0 0 0 0")))
		{
			String line1 = str;
			StringTokenizer token = new StringTokenizer(line1, " ");
			int row = Integer.parseInt(token.nextToken());
			int col = Integer.parseInt(token.nextToken());
			int centres = Integer.parseInt(token.nextToken());
			int query = Integer.parseInt(token.nextToken());
			
			boolean[][] yoga = new boolean[row][col];
			for(int i=0;i<centres;i++)
			{
				String temp = br.readLine();
				token = new StringTokenizer(temp, " ");
				int rowIndex = Integer.parseInt(token.nextToken())-1;
				int colIndex = Integer.parseInt(token.nextToken())-1;
				yoga[rowIndex][colIndex] = true;
			}
			for(int i=0;i<query;i++)
			{
				int[][] matrix = new int[row][col];
				int max = 0;
				int maxRow = -1;
				int maxCol = -1;
				int maxDistance = Integer.parseInt(br.readLine());
				for(int k=0;k<row;k++)
				{
					for(int l=0;l<col;l++)
					{
						//iterate over the yoga centres
						for(int m=0;m<row;m++)
						{
							for(int n=0;n<col;n++)
							{
								if(yoga[m][n]==true)
								{
									int rowDist = 0;
									int colDist = 0;
									if(m>k) rowDist = m-k;
									else rowDist = k-m;
									if(n>l) colDist = n-l;
									else colDist = l-n;
									if(rowDist+colDist<=maxDistance)
									{
										//increase the count of matrix
										matrix[k][l]++;
										if(matrix[k][l] > max)
										{
											max = matrix[k][l];
											maxRow = k;
											maxCol = l;
										}
										else if(matrix[k][l] == max)
										{
											if(l==maxCol)
											{
												if(k<maxRow)
												{
													maxRow = k;
												}
											}
											else if(l<maxCol)
											{
												maxCol = l;
												maxRow = k;
											}
										}
									}
								}
							}
						}
					}
				}
				System.out.println(max+" "+"("+(maxRow+1)+","+(maxCol+1)+")");
			}
			str = br.readLine();
		}
		
	}
}
