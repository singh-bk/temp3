package com.pattern.design.www;

public interface IItem {
	
	public int price();
	
	public int getBillablePrice(IVisitor visitor);
}
