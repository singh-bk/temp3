package com.epic.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class SpiralTest {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("spiral.txt")));
		int count = Integer.parseInt(br.readLine());
		char[][] input = new char[count][count];
		
		for(int i=0;i<count;i++){
			int j = 0;
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			while(token.hasMoreTokens()){
				char ch = token.nextToken().charAt(0);
				input[i][j] = ch;
				j++;
			}
		}
		
		int index =0;
		int min = 0;
		int max = count-1;
		while(min< max){
			for(int i=min;i<=max;i++){
				System.out.print(input[min][i]+" ");
				index++;
			}
			for(int i=min+1;i<=max;i++){
				System.out.print(input[i][max]+" ");
				index++;
			}
			for(int i=max-1;i>=min;i--){
				System.out.print(input[max][i]+" ");
				index++;
			}
			for(int i=max-1;i>=min+1;i--){
				System.out.print(input[i][min]+" ");
				index++;
			}
			min++;
			max--;
		}
		
		System.out.print(input[min][max]);
	}
}
