package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CoinTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("coin.txt")));
		int testCaseCount = Integer.parseInt(br.readLine());
		for(int i=0;i<testCaseCount;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			int jarCount = Integer.parseInt(token.nextToken());
			int coinCount = Integer.parseInt(token.nextToken());
			int outputCoinCount = Integer.parseInt(token.nextToken());
			int movesCount = 0;
			
			int[] jar = new int[jarCount];
			//get factors of outputCoincount
			boolean isPrime = CheckPrime(outputCoinCount);
			int factor = outputCoinCount;
			if(isPrime){
				factor = outputCoinCount-1; 
			}
			int maxFactor = GetMaxFactorLessThanJarCount(factor, jarCount);
			int maxCoinsInOneJar = outputCoinCount/maxFactor;
			int remCoins = outputCoinCount;
			int start = 0;
			int rem = 0;
			while(remCoins > 0)
			{
				 if((remCoins - maxCoinsInOneJar) >=0)
				 {
					 jar[start] = maxCoinsInOneJar;
					 remCoins = remCoins - maxCoinsInOneJar;
					 start++;
				 }
				 else
				 {
					 rem = remCoins;
					 remCoins = 0;
				 }
			}
			
			int emptyJars = jarCount - start;
			int count
			if(start>0)
			{
				while()
			}
				movesCount = emptyJars+rem+maxFactor*jar[0];
			else
				movesCount = emptyJars+rem;
			System.out.println(movesCount);
		}
	}
	
	public static boolean CheckPrime(int num)
	{
		boolean isPrime = true;
		for(int i=1;i<=num/2;i++){
			if(num%i == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static int GetMaxFactorLessThanJarCount(int num, int jarCount)
	{
		int maxFactor = 1;
		for(int i=1;i<=num/2;i++)
		{
			if(num%i == 0)
			{
				if(i <jarCount)
				{
					maxFactor = i;
				}
				else if(i == jarCount)
				{
					maxFactor = i;
					break;
				}
				else{
					break;
				}
			}
		}
		return maxFactor;
	}
}
