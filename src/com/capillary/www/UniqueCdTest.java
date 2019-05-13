package com.capillary.www;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UniqueCdTest{

    public static void main(String []args) throws UnsupportedEncodingException{
      generate();
    }
    
    public static void generate() throws UnsupportedEncodingException {
    	 Set<String> codes = new TreeSet<String>();
 		SecureRandom rng = new SecureRandom();
 		byte[] data = new byte[5];
 		for (int i = 0 ; i != 1000000 ; i++) {
 			rng.nextBytes(data);
 			long val = ((long)(data[0] & 0xFF))
 			| (((long)(data[1] & 0xFF)) << 8)
 			| (((long)(data[2] & 0xFF)) << 16)
 			| (((long)(data[3] & 0xFF)) << 24)
 			| (((long)(data[4] & 0xFF)) << 32);
 			String s = Long.toString(val, 36);
 			codes.add(s);
 		}
 		System.out.println("Generated "+codes.size()+" codes.");
 		System.out.println("ABCD1234".getBytes("UTF-16").length);
 		Iterator<String> iter = codes.iterator();
 		while(iter.hasNext()){
 		    System.out.print(iter.next()+":");
 		}
    }
    
    public static void generate2() throws UnsupportedEncodingException {
   	 Set<String> codes = new TreeSet<String>();
		SecureRandom rng = new SecureRandom();
		byte[] data = new byte[5];
		for (int i = 0 ; i != 1 ; i++) {
			rng.nextBytes(data);
			//System.out.println(data[0]+":"+data[1]+":"+data[2]+":"+data[3]+":"+data[4]);
			//System.out.println(data[0] & 0xFF);
			long val = ((long)(data[0] & 0xFF))
			| (((long)(data[1] & 0xFF)) << 8)
			| (((long)(data[2] & 0xFF)) << 16)
			| (((long)(data[3] & 0xFF)) << 24)
			| (((long)(data[4] & 0xFF)) << 32);
			//System.out.println(val);
			String s = Long.toString(val, 36);
			codes.add(s);
		}
		System.out.println("Generated "+codes.size()+" codes.");
		System.out.println("ABCD1234".getBytes("UTF-16").length);
		Iterator<String> iter = codes.iterator();
		while(iter.hasNext()){
		    System.out.print(iter.next()+":");
		}
   }
}
