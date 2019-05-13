package com.pattern.design.www;

public class BookItem implements IItem{

	private int price;
	
	private String name;
	
	private String author;
	
	private int quant;
	
	public BookItem(int price, String name, String author, int quant){
		this.price = price;
		this.name = name;
		this.author = author;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

}
