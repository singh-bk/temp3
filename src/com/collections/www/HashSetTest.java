package com.collections.www;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		set.add("bk");
		set.add("and");
		set.add("bks");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		
		set = new LinkedHashSet<String>();
		set.add("bk");
		set.add("and");
		set.add("bks");
		
		iter = set.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
	}
}
