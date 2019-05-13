package com.pattern.design.www;

public class StartegyPatternTest {

	public static void main(String[] args){
		StrategyContext context = new StrategyContext(new StrategyClass2());
		context.Print();
	}
}
