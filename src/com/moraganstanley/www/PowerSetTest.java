package com.moraganstanley.www;

import java.util.ArrayList;
import java.util.List;

public class PowerSetTest {

	public static void main(String[] args){
		char[] input = {'x','y','z'};
		int len = input.length;
		int count = (int)Math.pow(2, len);
		
		for(int i=0;i<count;i++){
			List<Character> list = new ArrayList<Character>();
			int quotient = i/2;
			int rem = i%2;
			if(quotient != 0) list.add(input[quotient-1]);
			if(rem != 0) list.add(input[rem-1]);
			quotient = rem/2;
			while(quotient != 0){
				list.add(input[quotient-1]);
				rem = quotient %2;
				if(rem != 0) list.add(input[rem-1]);
				quotient = rem/2;
			}
			for(int ii=0;ii<list.size();ii++){
				System.out.print(list.get(ii)+",");
			}
			System.out.println();
		}
	}
}
