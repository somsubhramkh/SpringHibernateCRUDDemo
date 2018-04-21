package com.niit.cruddemo.dao;

import java.util.List;

import com.niit.cruddemo.model.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int empId);
	public Employee findByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
	
}
