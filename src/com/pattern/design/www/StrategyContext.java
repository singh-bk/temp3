package com.pattern.design.www;

public class StrategyContext {

	StrategyInterface obj;
	
	public StrategyContext(StrategyInterface inter)
	{
		this.obj = inter;
	}
	
	public void Print()
	{
		obj.Print();
	}
}
