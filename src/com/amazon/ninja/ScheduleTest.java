package com.amazon.ninja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScheduleTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("schedule.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer token = new StringTokenizer(str, " ");
		int people = Integer.parseInt(token.nextToken());
		int duration = Integer.parseInt(token.nextToken());

		//All slots are free now
		int[] free = new int[1440];
		
		for(int i=0;i<people;i++)
		{
			str = br.readLine();
			token = new StringTokenizer(str, " ");
			int startHH = Integer.parseInt(token.nextToken());
			int startMM = Integer.parseInt(token.nextToken());
			int indexStart = startHH*60+startMM;
			int endHH = Integer.parseInt(token.nextToken());
			int endMM = Integer.parseInt(token.nextToken());
			int indexEnd = endHH*60+endMM;
			for(int k=indexStart;k<indexEnd;k++)
			{
				//the slot is not free
				free[k] = -1;
			}
		}
		int startFinal = -1;
		int endFinal = -1;
		
		for(int i=0;i<free.length;i++)
		{
			/*
			 * iterate over the free matrix
			 * 1. First occurrence of zero - starts the free slot
			 * 		keep increasing end  till you find a busy slot
			 * 2. If the slot is busy
			 * 		calculate endFinal - startFinal = currentDuration
			 * 		if  currentDuration > duration. Print startFinal and endFinal
			 * 		set startFinal = -1, endFinal = -1
			 */
			if(free[i] == 0)
			{
				if(startFinal == -1)
				{
					startFinal = i;
					endFinal = i;
				}
				endFinal = i;
			}
			else
			{
				if(startFinal!=-1)
				{
					PrintOutput(startFinal, endFinal, duration);
					startFinal = -1;
					endFinal = -1;
				}
			}
		}
		
		if(startFinal!=-1)
		{
			PrintOutput(startFinal, endFinal, duration);
		}

	}
	
	/**
	 * @param endFinal
	 * @param startFinal
	 * @param duration
	 */
	public static void PrintOutput(int startFinal, int endFinal, int duration){

		int currentDuration = endFinal - startFinal;
		if(currentDuration >= duration-1)
		{
			int div1 = startFinal/60; 
			String remDiv1 = div1+"";
			if(div1<10){
				remDiv1 = 0+""+remDiv1;
			}
			if(div1 == 24){
				remDiv1 = "00";
			}
			int rem1 = startFinal%60;
			String remStr1 = rem1+"";
			if(rem1<10){
				remStr1 = 0+""+remStr1;
			}
			int div2 = (endFinal+1)/60;
			String remDiv2 = div2+"";
			if(div2<10){
				remDiv2 = 0+""+remDiv2;
			}
			if(div2 == 24){
				remDiv2 = "00";
			}			
			int rem2 = (endFinal+1)%60;
			String remStr2 = rem2+"";
			if(rem2<10){
				remStr2 = 0+""+remStr2;
			}
			System.out.println(remDiv1+" "+remStr1 + " "+remDiv2+" "+remStr2);
		}
	}
}
