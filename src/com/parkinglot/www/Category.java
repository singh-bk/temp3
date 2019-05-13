package com.parkinglot.www;

public enum Category {

	GENERAL(1),
	MEMBER(2);
	
	int cat;
	
	private Category(int x){
		this.cat =x;
	}
}
