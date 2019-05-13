package com.amazon.interview;

public class FloodFillTest {

	public static void main(String[] args){
		int[][] input = {{1,1,0,0,1},{1,0,0,1,0},{1,1,0,1,0},{0,0,1,0,0}};
		boolean[][] isVisited = {};
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[i].length;j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
}
