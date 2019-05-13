package com.khoslalabs.www;

public class Department implements Type{

	private String code;
	private String name;
	
	public Department(){
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	  public String toString() {
	        return "Code : " + this.code + ";" + "Name : " + this.name;
	    }
}
