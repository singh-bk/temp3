package com.hp.util;

public class IndexofTest {

	public static void main(String[] args){
		String input = "your account 071-052***-006 has been debited with INR 900.00 on 07OCT as cash withdrawal.";
		String str = "071-052***-006";
		input = input.replaceAll(str, "");
		System.out.println(input);
	}
}
