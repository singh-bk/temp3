package com.concurrent.www;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadSafeStack<T> {

	Stack<String> stack = new Stack<String>();
	
	public void push(String str){
		AtomicReference<String> atomic = new AtomicReference<String>(stack.peek());
		String top = atomic.get();
		while(!atomic.compareAndSet(top, str));
		
	}
}
