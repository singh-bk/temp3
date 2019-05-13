package com.bt.www;


public class Employee implements Comparable<Employee>{

	private int id;
	
	public Employee(int id)
	{
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Employee emp) {
		if(this.id == emp.getId())
			return 0;
		else if(this.id > emp.getId())
			return 1;
		else
			return -1;
	}

	
	
}
