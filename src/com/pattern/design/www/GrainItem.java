package com.pattern.design.www;

public class GrainItem implements IItem{

	private String name;
	
	private int price;
	
	private int quant;
	
	public GrainItem(String name, int price, int quant){
		this.name = name;
		this.price = price;
		this.quant = quant;
	}
	
	@Override
	public int price() {
		return this.price;
	}

	@Override
	public int getBillablePrice(IVisitor visitor) {
		return visitor.getBillablePrice(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

}
