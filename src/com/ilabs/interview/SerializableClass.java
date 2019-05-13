package com.ilabs.interview;

import java.io.Serializable;

import com.thread.www.MyRunnable;

public class SerializableClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private String name;
	private transient String company;
	public static int staticVar;
	public transient Thread thread = new Thread(new MyRunnable());
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	public static int StaticMethod(){
		return staticVar;
	}
}
