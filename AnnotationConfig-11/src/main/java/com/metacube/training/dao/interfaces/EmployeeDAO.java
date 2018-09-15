package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkill;

public interface EmployeeDAO
{
	public List<Employee> getAllEmployee();
	
	public boolean toggleActivation();
	
	public boolean createEmployee(Employee employee);
	
	public Employee getLastAddedEmployee();
	
	public boolean addJobDetails(Employee employee);
	
	public Employee getEmployeeById(Employee employee);
	
	public List<Employee> getEmployeesBySkill(String skill);
	
	public boolean addSkill(EmployeeSkill employeeSkill);

	public Employee getEmployeeByEmailId(Employee employee);
}