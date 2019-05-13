package com.thread2.www;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i=0;
		for(i=0;i<100000;i++);

		for(i=0;i<100000;i++);

		for(i=0;i<100000;i++);

		for(i=0;i<100000;i++);

		for(i=0;i<100000;i++);
		return i;
	}

}
