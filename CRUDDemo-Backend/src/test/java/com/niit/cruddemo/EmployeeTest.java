package com.niit.cruddemo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.cruddemo.config.AppContext;
import com.niit.cruddemo.model.Employee;
import com.niit.cruddemo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)
public class EmployeeTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void setup() {
		if(employeeService.findEmployeesByName("Ryan")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ryan").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("John")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("Chris")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
		}
		Employee emp1=new Employee();
		emp1.setName("John");
		emp1.setEmail("john@gmail.com");
		Employee emp2=new Employee();
		emp2.setName("Chris");
		emp2.setEmail("chris@gmail.com");
		employeeService.addEmployee(emp1);
		employeeService.addEmployee(emp2);
	}
	
	@After
	public void teardown() {
		
		employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
		employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
		if(employeeService.findEmployeesByName("Ryan")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ryan").getEmpId());
		}
		
	}
	
	
	@Test
	public void testAddEmployee() {
		
		Employee emp=new Employee();
		emp.setName("Ryan");
		emp.setEmail("ryan@gmail.com");
		
		assertEquals(true, employeeService.addEmployee(emp));
				
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testAddEmployeeFailure() {
		
		Employee emp=new Employee();
		emp.setName("John");
		emp.setEmail("john@gmail.com");
		
		assertEquals(false, employeeService.addEmployee(emp));
				
	}

}
