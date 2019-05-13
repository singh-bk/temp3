package com.sirion.interview;

public class Child extends Parent{

	Child()
	{
		this(10);
		System.out.println("Child Constructor without param");
	}
	
	Child(int a){
		super(a);
		System.out.println("Child Constructor with param");
	}
	public static void StaticMethod()
	{
		System.out.println("IN child class");
	}
	
	
	public static void main(String[] args){
		Parent par = new Child();
		par.StaticMethod();
	}
}
