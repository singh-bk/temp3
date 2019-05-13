package com.amazon.interview;


public class FactorialTest {

	public static void main(String[] args){
		int i =5;
		System.out.println(factorial(i));
	}
	
	public static int factorial(int num){
		System.out.println("Inside factorial:"+num);
		if(num == 1)
			return 1;
		return num*factorial(num-1);
	}
}
