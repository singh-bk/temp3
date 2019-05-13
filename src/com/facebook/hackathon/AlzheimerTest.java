package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AlzheimerTest {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("alzheimer.txt")));
		int testCaseCount = Integer.parseInt(br.readLine());
		for(int i=0;i<testCaseCount;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			int grandChildCount = Integer.parseInt(token.nextToken());
			int hcd =  Integer.parseInt(token.nextToken());
			int totalAge = 0;
			int[] grandChildMoney = new int[grandChildCount];
			str = br.readLine();
			token = new StringTokenizer(str, " ");
			int j=0;
			//popluate the input
			while(token.hasMoreTokens())
			{
				int temp = Integer.parseInt(token.nextToken());
				totalAge = totalAge+temp;
				grandChildMoney[j] = temp;;
				j++;
			}
			
			/*
			 * check if all the money are divisible by hcd
			 * If not, increase it to make it divisble by hcd
			 */
			for(int k=0;k<grandChildMoney.length;k++)
			{
				int temp = grandChildMoney[k]%hcd;
				if(temp!=0){
					grandChildMoney[k] = grandChildMoney[k]+(hcd-temp);
				}
			}
			/*
			 * Check every pair of grandChildMoney
			 * 		if hcd of pair is greater than the input hcd
			 * 			increase the pair with lower index and check
			 * 			if still then increase the higher pair and check
			 * 			do this till you satisfy the condition
			 */
			for(int jj=0;jj<grandChildMoney.length-1;jj++)
			{
				for(int kk=jj+1;kk<grandChildMoney.length;kk++)
				{
					int currentHCD = -1;
					/*
					 * any of the grandchildage is zero, hcd becomes the other grandChild age
					 * if both are zero then currentHCD is kept at o which is read as max HCD
					 */
					currentHCD = GetHCD(grandChildMoney[jj], grandChildMoney[kk]);
					if(grandChildMoney[jj] ==0)
					{
						currentHCD = grandChildMoney[kk];
					}
					else if(grandChildMoney[kk] == 0){
						currentHCD = grandChildMoney[jj];
					}
					/*
					 * if current hcd ==0, means both are zero
					 * 		increase the first index by hcd.
					 */
					if(currentHCD == 0)
					{
						grandChildMoney[jj] = grandChildMoney[jj]+hcd;
					}
					else if(currentHCD > hcd)
					{
						grandChildMoney[jj] = grandChildMoney[jj]+hcd;// factor is 1
						boolean indexModified = true;// true indicates that first[jj] was modified - false stands for second[kk]
						int factor = 1;
						currentHCD = GetHCD(grandChildMoney[jj], grandChildMoney[kk]);
						while(currentHCD > hcd)
						{
							if(indexModified)
							{
								grandChildMoney[jj] = grandChildMoney[jj]-(factor*hcd);
								grandChildMoney[kk] = grandChildMoney[kk]+(factor*hcd);
								currentHCD = GetHCD(grandChildMoney[jj], grandChildMoney[kk]);
								indexModified = false;
								factor++;
							}
							else
							{
								grandChildMoney[kk] = grandChildMoney[kk]-(factor*hcd);
								grandChildMoney[jj] = grandChildMoney[jj]+(factor*hcd);
								currentHCD = GetHCD(grandChildMoney[jj], grandChildMoney[kk]);
								indexModified = false;
								factor++;
							}
						}
						kk--;
					}
					
				}
			}
			int totalAmount = 0;
			for(int ll=0;ll<grandChildMoney.length;ll++)
			{
				totalAmount = totalAmount+grandChildMoney[ll];
			}
				System.out.println("Case #"+(i+1)+": "+(totalAmount-totalAge));
		}
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public static int GetHCD(int x, int y)
	{
		  if (y == 0) {
		      return x;
		    }
		    return GetHCD(y, x % y);
	}
}
