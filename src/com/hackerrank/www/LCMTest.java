package com.hackerrank.www;

import java.util.Scanner;

public class LCMTest {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        
        for(int i=0;i<testcase;i++){
        	int count = in.nextInt();
        	int prime = in.nextInt();
        	
        	int[] input = new int[count];
        	for(int k=0; k<count;k++){
        		input[k] = in.nextInt();
        	}
        	
        	long lcm = input[0];
        	
        	for(int k=1;k<count;k++){
        		lcm = getLcm(lcm,input[k]);
        	}
        	String op = lcm%prime==0?"YES":"NO";
        	System.out.println(op);
        }

	}
	
	public static long getLcm(long x, long y){
		long gcd = 1;
		//int lcm = 1;
		long smaller = (x<y)==true?x:y;
		long larger = (x<y)==true?y:x;
		
		gcd = findGCD(larger, smaller);
		
		
		
		return ((x*y)/gcd);
	}
	
	private static long findGCD(long larger, long smaller) {
		if (smaller == 0) {
			return larger;
		}
		return findGCD(smaller, larger % smaller);
	}

}
