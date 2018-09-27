package com.capgemini.EmployeeProducer;

public class Employee {
	private String empId;
	private String name;
	private String designation;
	private int salary;
	
	public Employee()
	{
		super();
	}
	
	public Employee(String empid, String name, String designation, int salary) {
		super();
		this.empId = empid;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public String getEmpid() {
		return empId;
	}
	public void setEmpid(String empid) {
		this.empId = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
