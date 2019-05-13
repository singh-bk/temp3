package com.softwareag.www;

import java.io.IOException;

public class Parent {

	protected Object method() throws IOException{
		return "Parent";
	}
	
	protected Object method(String param){
		return "Parent:"+param;
	}
}
