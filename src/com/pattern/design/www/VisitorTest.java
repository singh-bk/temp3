package com.pattern.design.www;

public class VisitorTest {

	public static void main(String[] args) {
		BookItem book = new BookItem(300, "The Fountainhead", "Ayn Rand", 1);
		GrainItem grain = new GrainItem("rice", 110, 1);
		
		VisitorImpl visitor = new VisitorImpl();
		int price1 = book.getBillablePrice(visitor);
		int price2 = grain.getBillablePrice(visitor);
		System.out.println(price1+price2);
	}
}
