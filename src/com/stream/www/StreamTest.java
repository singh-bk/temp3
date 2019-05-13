package com.stream.www;

import java.util.Arrays;
import java.util.List;


public class StreamTest {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(new Integer[]{1,2,3,1,2,3,4,3,5,6});
		int x = input.stream().distinct().filter(i-> i%7==0).findFirst().orElse(-1);
		boolean y = input.stream().allMatch(i-> i%1==0);
		System.out.println(x);
		System.out.println(y);
	}
}
