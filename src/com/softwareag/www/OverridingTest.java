package com.softwareag.www;

public class OverridingTest {

	public static void main(String[] args) throws Exception{
		Parent obj = new Child();
		System.out.println(obj.method());
		System.out.println(obj.method("param"));
	}
}
