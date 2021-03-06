package com.klabs.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class TestClass {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader(new File("khosla.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringTokenizer token;
		int caseId = 1;
		
		String type = null;
		Employee emp = null;
		List<Employee> employeeList = new LinkedList<Employee>();
		Department dep = null;
		List<Department> departmentList = new LinkedList<Department>();
		String[] order = null;
		
		while((input = br.readLine()) != null && input.length()>0){
			if(caseId == 3 && input.contains(":")){
				caseId = 1;
			}
			switch(caseId){
				case 1: token = new StringTokenizer(input, ":");
						token.nextToken();
						type = token.nextToken();
						caseId = 2;
						break;
				case 2: token = new StringTokenizer(input, ",");
						order = new String[token.countTokens()];
						int start = 0;
						while(token.hasMoreTokens()){
							order[start] = token.nextToken();
							start++;
						}
						caseId = 3;
						break;
				case 3: 
						if( type != null && type.equals("Department")){
							dep = new Department();
						}
						else if(type != null && type.equals("Employee")){
							emp = new Employee();
						}
						token = new StringTokenizer(input, ",");
						
						while(token.hasMoreTokens()){
							if(order != null && order.length > 0){
								for(int index =0; index < order.length; index++){
									if(type != null && type.equals("Department")){
										if(order[index].equalsIgnoreCase("code")){
											dep.setCode(token.nextToken());
										}
										else if(order[index].equalsIgnoreCase("name")){
											dep.setName(token.nextToken());
										}
									}
									else if(type != null && type.equals("Employee")){
										if(order[index].equalsIgnoreCase("name")){
											emp.setName(token.nextToken());
										}
										else if(order[index].equalsIgnoreCase("age")){
											emp.setAge(Integer.parseInt(token.nextToken()));
										}
										else if(order[index].equalsIgnoreCase("salary")){
											emp.setSalary(Integer.parseInt(token.nextToken()));
										}
									}
								}
							}
							if(type != null && type.equals("Department")){
								departmentList.add(dep);
							}
							else if(type != null && type.equals("Employee")){
								employeeList.add(emp);
							}
						}
						break;
			}
			
		}
		if(departmentList != null && departmentList.size() > 0){
			for(int index = 0; index<departmentList.size();index++){
				System.out.println(departmentList.get(index));
			}
		}
		if(employeeList != null && employeeList.size() > 0){
			for(int index = 0; index<employeeList.size();index++){
				System.out.println(employeeList.get(index));
			}
		}
		if(br != null){
			br.close();
		}
	}
}

class Employee implements Type{

    private String name;
    private int age;
    private int salary;

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public String toString() {
        return "Name : " + this.name + ";" + "Age : " + this.age;
    }
}

class Department implements Type{

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

class Factory {

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

interface Type {

}
