package com.interviewstreet.facebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("mastermind.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCaseCount;i++)
		{
			String input = br.readLine();
			StringTokenizer token = new StringTokenizer(input, " ");
			int max_sequence_elem = Integer.parseInt(token.nextToken());
			int no_of_guesses_per_row = Integer.parseInt(token.nextToken());
			int row_count_of_guesses = Integer.parseInt(token.nextToken());
			
			int[][] guess_matrix = new int[row_count_of_guesses][no_of_guesses_per_row];
			//probable matrix will be comma seperate int values
			String[][] probable_matrix = new String[row_count_of_guesses][no_of_guesses_per_row];
			int[] correct_guess = new int[row_count_of_guesses];
			//populate the input
			for(int j=0;j<row_count_of_guesses;j++)
			{
				input = br.readLine();
				token = new StringTokenizer(input, " ");
				int col_count = 0;
				while(token.hasMoreTokens())
				{
					if(col_count < no_of_guesses_per_row)
					{
						guess_matrix[j][col_count] = Integer.parseInt(token.nextToken());
						col_count++;
					}
					else
					{
						correct_guess[j] = Integer.parseInt(token.nextToken());
					}
				}
			}
			
			
			/*
			 * If correct_guess is zero
			 * 		all entries are incorrect
			 * 		For each entry in the guess matrix
			 * 			populate the probable matrix - in sorted order
			 */
			
			for(int j=0;j<row_count_of_guesses;j++)
			{
				if(correct_guess[j] == 0)
				{
					for(int k=0;k<no_of_guesses_per_row;k++)
					{
						int exclude_num = guess_matrix[j][k];
						String entry_for_probable_matrix = "";
						for(int ll=1;ll<max_sequence_elem;ll++)
						{
							if(ll!=exclude_num)
							{
								entry_for_probable_matrix = entry_for_probable_matrix+","+ll;
							}
						}
						probable_matrix[j][k] = entry_for_probable_matrix;
					}
				}
				else
				{
					/*
					 * Find the total no of possible combinations
					 */
					int total_combinations = (binomial(no_of_guesses_per_row, correct_guess[j])).intValue();
					System.out.println(total_combinations);
					
					/*
					 * For each combination
					 * 		
					 */
				}
			}
		}
	}
	
	/**
	 * 
	 * @param N
	 * @param K
	 * @return
	 */
	static BigInteger binomial(final int N, final int K) {
	    BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    }
	    return ret;
	}}
