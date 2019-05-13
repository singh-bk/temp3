package com.hackerrank.www;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1 {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String inputStr = scan.nextLine();
        //System.out.println(count+":"+inputStr);
        StringTokenizer tokens = new StringTokenizer(inputStr, " ");
        int[] input = new int[count];
        int i=0;
        while(tokens.hasMoreTokens()){
        	input[i] = Integer.parseInt(tokens.nextToken());
        	i++;
        }
        Arrays.sort(input);
        System.out.println(count);
        int cut = input[0];
        int same = 1;
        int total = 0;
        for(i=1;i<count;i++){
        	if(input[i] == input[i-1]){
        		same++;
        	}else{
        		total = total+same;
        		System.out.println(count-total);
        		same=1;
        	}
        }

	}
}
