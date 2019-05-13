package com.khoslalabs.www;

public class Factory {

	public Type getInstance(String input){
		Type type = null;
		if(input != null && input.equals("Department")){
			type = new Department();
		}
		else if(input != null && input.equals("Employee")){
			type = new Employee();
		}
		return type;
	}
}
