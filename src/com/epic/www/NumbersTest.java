package com.epic.www;

public class NumbersTest {

	public static void main(String[] args){
		int n = 3;
		int min = (int) Math.pow(10, n-1);
		int max = (int) Math.pow(10,n);
		//System.out.println();
		for(int i=min;i<max;i++)
		{
			int[] digits = new int[n];
			int rem = i;
			for(int j=0;j<n;j++)
			{
				digits[j] = rem
						/(int)(Math.pow(10, n-j+1));
				rem = n%(int)(Math.pow(10, n-j+1));				
			}
			boolean var = true;
			for(int j=0;j<n-1;j++)
			{
				if(digits[j]>digits[n-1])
				{
					var = false;
					break;
				}
			}
			if(var)
			{
				System.out.print(i+" ");
			}
		}
	}
}
