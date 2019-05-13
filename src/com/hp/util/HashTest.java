package com.hp.util;

public class HashTest {

	public static void main(String[] args){
		System.out.println(indexFor(hash(25),10));
	}
	static int indexFor(int h, int length) {
		return h & (length - 1);
	}
	static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
	 }
}
