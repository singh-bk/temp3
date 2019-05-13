package com.oracle.www;

import java.util.LinkedList;
import java.util.Stack;

public class ListSumTest {

	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		//list2.add(7);
		list2.add(8);
		list2.add(9);
		list2.add(3);
		list2.add(8);
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> sum_stack = new Stack<Integer>();
		
		
		for(int i=0;i<list.size();i++){
			stack1.push(list.get(i));
		}
		for(int i=0;i<list2.size();i++){
			stack2.push(list2.get(i));
		}
		int sum = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(!stack1.isEmpty()){
				sum = sum+stack1.pop();
			}
			if(!stack2.isEmpty()){
				sum = sum+stack2.pop();
			}
			if(sum >= 10){
				int rem = sum%10;
				sum_stack.push(rem);
				sum = 1;
			}
			else{
				sum_stack.push(sum);
				sum = 0;
			}
		}
		while(!sum_stack.isEmpty())
			System.out.print(sum_stack.pop()+" ");
	}
}
