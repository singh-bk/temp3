package com.microsoft.interview;

public class BitTest {

	public static void main(String[] args) {
		int bit = 12;
		int num = 275;
		int count = 0;
		for(int i=0;i<=bit;i++){
			int temp = num >> i;
			if((temp & 1) ==1) count++;
		}
		System.out.println(count);
	}
}
