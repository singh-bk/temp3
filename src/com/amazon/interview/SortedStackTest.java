package com.amazon.interview;

import www.graph.util.SortedStack;

public class SortedStackTest {

	public static void main(String[] args){
		SortedStack stack = new SortedStack();
		stack.push(7);
		stack.push(5);
		stack.push(8);
		stack.push(3);
		stack.push(1);
		stack.push(6);
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
		stack.sortedPush(7);
		stack.sortedPush(5);
		stack.sortedPush(8);
		stack.sortedPush(3);
		stack.sortedPush(1);
		stack.sortedPush(6);
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
}
