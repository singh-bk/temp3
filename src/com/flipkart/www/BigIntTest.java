package com.flipkart.www;

public class BigIntTest {

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args){
		String input1 = "1234567";
		String input2 = "79345678";
		int x = 9;
		char xx = (char)(x+'0');
		System.out.println(xx);
		char[] sum = sum(input1, input2);
		System.out.println(sum);
		
		char[] diff = subtract(input2, input1);
		System.out.println(diff);
	}
	
	/**
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	private static char[] sum(String input1, String input2){
		
		char[] bytes1 = input1.toCharArray();
		char[] bytes2 = input2.toCharArray();
		
		int len1 = bytes1.length;
		int len2 = bytes2.length;
		
		int max = (len1 > len2 ) ? len1: len2;
		char[] sum = new char[max+1];
		//System.out.println(sum);
		
		int carry = 0;
		int index1 = len1-1;
		int index2 = len2-1;
		for(int x=max; x>=0;x--){
			int first = 0;
			int second = 0;
			if(index1 >=0){
				first = bytes1[index1]-'0';
				//System.out.println(first);
			}
			if(index2 >=0){
				second = bytes2[index2]-'0';
				//System.out.println(second);
			}
			int add = first+second+carry;
			//System.out.println(add);
			int rem = add%10;
			carry = add/10;
			sum[x] = (char)(rem+'0');
			index1--;index2--;
		}
		return sum;
	}

	/**
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	private static char[] subtract(String input1, String input2){
		char[] bytes1 = input1.toCharArray();
		char[] bytes2 = input2.toCharArray();
		
		int len1 = bytes1.length;
		int len2 = bytes2.length;
		
		int max = (len1 > len2 ) ? len1: len2;
		char[] diff = new char[max];
		
		int carry = 0;
		int index1 = len1-1;
		int index2 = len2-1;
		for(int x=max-1; x>=0;x--){
			int first = 0;
			int second = 0;
			if(index1 >=0){
				first = bytes1[index1]-'0';
				//System.out.println(first);
			}
			if(index2 >=0){
				second = bytes2[index2]-'0';
				//System.out.println(second);
			}
			first = first -carry;
			int minus = 0;
			if(first >= second){
				minus = first - second;
			}
			else{
				minus = second - first;
				carry = 1;
			}
			//System.out.println(minus);
			diff[x] = (char)(minus+'0');
			index1--;index2--;
		}
		return diff;
	}
	
	
}
