package com.amazon.ninja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectedTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("connected.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int matrix_size = Integer.parseInt(br.readLine());
			int[][] matrix = new int[matrix_size][matrix_size];
			//all boolean are false by default
			boolean[][] traversed_matrix = new boolean[matrix_size][matrix_size];
			
			//populate the matrix with the input
			for(int j=0;j<matrix_size;j++)
			{
				String inputStr = br.readLine();
				StringTokenizer token = new StringTokenizer(inputStr, " ");
				for(int k=0;k<matrix_size;k++)
				{
					int input = Integer.parseInt(token.nextToken());
					matrix[j][k] = input;
				}
			}
			
			/*
			 * Create 2 Empty Queues. One queue will never be decremented.
			 * Iterate over the matrix
			 * 1. When the matrix[][] == 1
			 * 		
			 */
			
			Queue<String> queue = new LinkedList<String>();
			//Queue<String> increasing_queue = new LinkedList<String>();
			int count = 0;
			for(int j=0;j<matrix_size;j++)
			{
				for(int k=0;k<matrix_size;k++)
				{
					if(matrix[j][k] == 1 && traversed_matrix[j][k]==false)
					{
						traversed_matrix[j][k] = true;
						count++;
						queue.add(j+","+k);
						//increasing_queue.add(j+","+k);
						while(!queue.isEmpty())
						{
							String node = queue.remove();
							StringTokenizer token = new StringTokenizer(node, ",");
							int x = Integer.parseInt(token.nextToken());
							int y = Integer.parseInt(token.nextToken());
							
							// check all its 8 neighbors and insert into the queue when you find 1. 
							if(y>0 && matrix[x][y-1]==1 && traversed_matrix[x][y-1]==false)
							{
								queue.add(x+","+(y-1));
								traversed_matrix[x][y-1] = true;
								//increasing_queue.add(x+","+(y-1));
							}
							if(x>0 && y>0 && matrix[x-1][y-1]==1 && traversed_matrix[x-1][y-1]==false)
							{
								queue.add((x-1)+","+(y-1));
								traversed_matrix[x-1][y-1] = true;
								//increasing_queue.add(x-1+","+(y-1));
							}
							if(x>0 && matrix[x-1][y]==1 && traversed_matrix[x-1][y]==false)
							{
								queue.add((x-1)+","+y);
								traversed_matrix[x-1][y] = true;
								//increasing_queue.add(x-1+","+y);
							}
							
							if(x<matrix_size-1 && y>0 && matrix[x+1][y-1]==1 && traversed_matrix[x+1][y-1]==false)
							{
								queue.add((x+1)+","+(y-1));
								traversed_matrix[x+1][y-1] = true;
								//increasing_queue.add(x+1+","+(y-1));
							}			
							if(x<matrix_size-1 && matrix[x+1][y]==1 && traversed_matrix[x+1][y]==false)
							{
								queue.add((x+1)+","+y);
								traversed_matrix[x+1][y] = true;
								//increasing_queue.add(x+1+","+y);
							}		
							if(x<matrix_size-1 && y<matrix_size-1 && matrix[x+1][y+1]==1 && traversed_matrix[x+1][y+1]==false)
							{
								queue.add((x+1)+","+(y+1));
								traversed_matrix[x+1][y+1] = true;
								//increasing_queue.add(x+1+","+(y+1));
							}	
							if(y<matrix_size-1 && matrix[x][y+1]==1 && traversed_matrix[x][y+1]==false)
							{
								queue.add(x+","+(y+1));
								traversed_matrix[x][y+1] = true;
								//increasing_queue.add(x+1+","+(y+1));
							}	
							if(x>0 && y<matrix_size-1 && matrix[x-1][y+1]==1 && traversed_matrix[x-1][y+1]==false)
							{
								queue.add((x-1)+","+(y+1));
								traversed_matrix[x-1][y+1] = true;
								//increasing_queue.add(x-1+","+(y+1));
							}		
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
