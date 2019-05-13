package com.bt.www;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args){
		 HashSet<Employee> set = new HashSet<Employee>();
		 Employee emp1 = new Employee(5);
		 Employee emp2 = new Employee(5);
		 set.add(emp1);
		 set.add(emp2);
		 System.out.println(set.size());
	}
}
