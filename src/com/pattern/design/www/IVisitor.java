package com.pattern.design.www;

/**
 * 
 * @author bk
 * External interface that will perform extra functionality on other set of classes
 * without changing the classes enclosed. 
 */
public interface IVisitor {

	public int getBillablePrice(GrainItem grain);
	
	public int getBillablePrice(BookItem book);
}
