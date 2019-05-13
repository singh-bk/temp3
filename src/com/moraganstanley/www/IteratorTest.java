package com.moraganstanley.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[]args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<15;i++){
			list.add(i);
		}
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			int num = iter.next();
			if(num == 10)
				iter.remove();
			System.out.print(num+" ");
		}
		System.out.println();
		for(int num : list){
			//int num = list.get(i);
			if(num == 7)
				list.remove(num);
			System.out.print(num+" ");
		}
		
	}
}
