package com.khoslalabs.www;

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