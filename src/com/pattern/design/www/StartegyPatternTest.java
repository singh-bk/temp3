package com.pattern.design.www;

public class StartegyPatternTest {

	public static void main(String[] args){
		final StrategyContext context = new StrategyContext(new StrategyClass2());
		final StrategyContext context2 = new StrategyContext(new StrategyClass1());
		context.Print();
		context2.Print();
	}
}
