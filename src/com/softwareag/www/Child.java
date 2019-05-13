package com.softwareag.www;

import java.io.IOException;

public class Child extends Parent{

	public String method()  throws IOException{
		return "child";
	}
	public String method(String param){
		return "Child:"+param;
	}
}
