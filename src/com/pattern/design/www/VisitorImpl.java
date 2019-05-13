package com.pattern.design.www;

public class VisitorImpl implements IVisitor{

	@Override
	public int getBillablePrice(GrainItem grain) {
		int quant = grain.getQuant();
		int price = grain.price();
		int discount = 20;
		return price*quant-discount;
	}

	@Override
	public int getBillablePrice(BookItem book) {
		int quant = book.getQuant();
		int price = book.getPrice();
		int discount = 30;
		return price*quant - discount;
	}


}
