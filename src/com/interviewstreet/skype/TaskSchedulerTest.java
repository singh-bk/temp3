package com.interviewstreet.skype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TaskSchedulerTest {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("task.txt")));
		int task_count = Integer.parseInt(br.readLine());
		int[] d = new int[task_count];
		int[] m = new int[task_count];
		
		for(int i=0;i<task_count;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			d[i] = Integer.parseInt(token.nextToken());
			m[i] = Integer.parseInt(token.nextToken());
		}
		
		
	}
}
