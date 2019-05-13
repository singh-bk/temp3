package com.qwest.www;

public class PyramidTest {

	public static void main(String[] args)
	{
		int input = 35;
		int maxSize = (int) Math.sqrt(29);
		int[] high = new int[maxSize];
		int[] low = new int[maxSize];
		int lastHigh = 0;
		int lastLow = 0;
		boolean isHigh = true;
		boolean isOdd = true;
		int sameHighCount = 0;
		int sameLowCount = 0;
		StringBuffer output = new StringBuffer("");
		while(input >= 5)
		{
			int sum =0;
			int count = 1;
			if(!isHigh && !isOdd)
				count = 2;
			while(sum < input)
			{
				sum = sum+(count*count);
				if(isHigh)
					count++;
				else count = count+2;
			}
			if(isHigh)
			{
				count--;
				if(sum != input)
				{
					sum = sum - count*count;
					count--;
				}
				int temp =0;
				if(count != lastHigh)
				{
					while(high[temp]!=0) temp++;
					//high[temp] = sum;
					high[temp] = count;
					output.append(high[temp]+"H ");
					input = input - sum;
					lastHigh = high[temp];
				}
				else
				{
					if(sameHighCount>=1)
						break;
					sameHighCount++;
				}
				System.out.println(input);
				isHigh = false;

			}
			else 
			{
				count = count-2;
				if(sum != input)
				{
					sum = sum - count*count;
					count = count -2;
				}
				int temp =0;
				if(count != lastLow)
				{
					while(low[temp]!=0) temp++;
					//low[temp] = sum;
					low[temp] = count;
					output.append(low[temp]+"L ");
					input = input - sum;
					lastLow = low[temp];
				}
				else
				{
					if(sameLowCount>=1)
						break;
					sameLowCount++;
				}
				System.out.println(input);
				isHigh = true;
			}
		}
		System.out.println(output);
	}
}
