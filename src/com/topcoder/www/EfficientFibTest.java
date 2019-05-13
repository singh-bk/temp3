package com.topcoder.www;

public class EfficientFibTest {

	private static int count= 0;
	public static void main(String[] args){
		int input = 154;
		int[] memo = new int[input+1];
		for(int i=0;i<memo.length;i++){
			memo[i] = -1; 
		}
		System.out.println(fib(input));
		System.out.println(count);
		count = 0;
		System.out.println(fib(input, memo));
		System.out.println(count);
	}
	
	public static int fib(int n){
		count++;
		if(n == 0){
			return 0;
		}
		else if(n == 1){
			return 1;
		}
		else{
			return (fib(n-2)+fib(n-1)); 
		}
	}
	
	/**
	 * @param n
	 * @param memo
	 * @return
	 */
	public static int fib(int n, int[] memo){
		count++;
		if(n == 0){
			memo[0] = 0;
			return 0;
		}
		else if(n == 1){
			memo[1]= 1;
			return 1;
		}
		else{
			if(memo[n-2] != -1 && memo[n-1] != -1){
			}
			else if(memo[n-2] != -1){
				memo[n-1] = fib(n-1,memo);
			}
			else if(memo[n-1] != -1){
				memo[n-2] = fib(n-2, memo);
			}
			else{
				memo[n-2] = fib(n-2, memo);
				memo[n-1] = fib(n-1,memo);
			}
			return (memo[n-2]+memo[n-1]);
		}
	}
	
}
