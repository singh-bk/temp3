package com.interviewstreet.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(getXNumber(n));
	}
	
	  static int getXNumber(int n) 
	  {
		  int product = 1;
		  int smallest_factor = 2;
		  //initialze the factor array
		  int[] factor = new int[100];
		  for(int i=0;i<factor.length;i++)
		  {
			  factor[i] = 1;
		  }
		  while(n%smallest_factor != 0)
		  {
			  smallest_factor++;
		  }
		  factor[0] = smallest_factor;
		  int index = 1;
		  int dividend = n/smallest_factor;
		  int remainder = n%smallest_factor;
		  while(!(dividend == 1 && remainder == 0))
		  {
			  while(dividend%smallest_factor != 0)
			  {
				  smallest_factor++;
			  }
			  factor[index] = smallest_factor;
			  index++;
			  remainder = dividend%smallest_factor;
			  dividend = dividend/smallest_factor;
			  
		  }
		  
		  StringBuilder str = new StringBuilder("");
			  
		  for(int i=0;i<factor.length;i++)
		  {
			  if(factor[i] > 1)
			  {
				  str.append(factor[i]);
			  }
			  else
			  {
				  break;
			  }
		  }
		  //System.out.println(str);
		  int final_product = 1;
		  for(int i=0;i<str.toString().length();i++)
		  {
			  final_product = final_product*Integer.parseInt(str.substring(i,i+1));
		  }
		  String strin = str.toString();
		  for(int i=0;i<str.toString().length();i++)
		  {
			  int one = Integer.parseInt(strin.substring(i,i+1));
			  int two = Integer.parseInt(strin.substring(i+1,i+2));
			  if(one*two < one*10+two)
			  {
				  strin.r = "0";
			  }
		  }
		  //System.out.println(final_product);
		  if(final_product == n)
			  product = Integer.parseInt(str.toString());
		  else
			  product = -1;
		  return product;
		  
	  }
}
