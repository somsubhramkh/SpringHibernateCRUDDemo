package com.niit.cruddemo.service;

import java.util.List;

import com.niit.cruddemo.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public Employee findEmployeesById(int empId);
	public Employee findEmployeesByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
}
