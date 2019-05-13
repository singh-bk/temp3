package com.amazon.interview;

import java.util.StringTokenizer;

public class Temp {

	public static void main(String[] args)
	{
		String str1 = "123";
		String str2 = "456";
		str2 = str1;
		str1 = "wewe";
		System.out.println(str2);
		System.out.println(str1);
		
		float a = (float)5.678;
		float b = (float)9.789;
		System.out.println(b-a);
		str1 = Float.toString(a);
		str2 = Float.toString(b);
		System.out.println(str1+str2);
		StringTokenizer token = new StringTokenizer(str1,".");
		StringTokenizer token2 = new StringTokenizer(str2,".");
		int aa = 0, aa2=0, bb =0, bb2=0;
		aa = Integer.parseInt(token.nextToken());
		aa2 = Integer.parseInt(token.nextToken());
		bb = Integer.parseInt(token2.nextToken());
		bb2 = Integer.parseInt(token2.nextToken());
		System.out.println((bb-aa)+" "+(bb2-aa2));
		float op = Float.parseFloat((bb-aa)+"."+(bb2-aa2));
		System.out.println(op);

	}
}
