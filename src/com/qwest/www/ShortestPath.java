package com.qwest.www;

public class ShortestPath {

	public static void main(String[] args){
		//int[] arr = {1, 2, 2, 4, 4, 3, 1, 3, 3, 1};
		int[] arr = {1,2,2,3,3,4,4,5,5,1};
		int noOfNodes = CountNodes(arr);
		System.out.println(noOfNodes);
		int[][] matrix = new int[noOfNodes][noOfNodes];
		//initialize the matrix
		for(int i=0;i<noOfNodes;i++)
			for(int j=0;j<noOfNodes;j++)
			{
				if(i==j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 99999;
			}

		//parse the input
		for(int i=0;i<arr.length;i=i+2)
		{
			int first = arr[i]-1;
			int second = arr[i+1]-1;
			matrix[first][second] = 1;
		}
		
		while(!CheckIfComplete(matrix))
		{
			for(int i=0;i<matrix.length;i++)
			{
				for(int j=0;j<matrix[i].length;j++)
				{
					if(i!=j)
					{
						int initialDistance = matrix[i][j];
						if(initialDistance != 99999)
						{
							for(int k=0;k<matrix[j].length;k++)
							{
								if(matrix[j][k]!=99999 && matrix[j][k]!=0)
								{
									int distanceOfKFromI= initialDistance+matrix[j][k];
									if(distanceOfKFromI < matrix[i][k])
									{
										matrix[i][k] = distanceOfKFromI;
									}
								}
							}
						}
					}
				}
			}
		}
		int sum = 0;
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++)
				sum = sum+matrix[i][j];
		System.out.println(sum);
	}
	
	/**
	 * Checks if the input contains 99999
	 * @param input
	 * @return
	 */
	public static boolean CheckIfComplete(int[][] input)
	{
		boolean val = true;
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input[i].length;j++)
			{
				if(input[i][j] == 99999)
				{
					val = false;
					break;
				}
			}
			if(!val)
				break;
		}
		return val;
	}
	
	public static int CountNodes(int[] input)
	{
		int ret = 0;
		for(int i=0;i<input.length;i++)
			if(input[i]>ret)
				ret = input[i];
		
		return ret;
	}
}
