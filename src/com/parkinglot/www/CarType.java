package com.parkinglot.www;

public enum CarType {

	HATCHBACK(1),
	SEDAN(2),
	SUV(3);
	
	int type;
	
	private CarType(int x){
		this.type = x;
	}
}
