package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkill;

public interface EmployeeService
{
	public List<Employee> getAllEmployee();
	
	public boolean createEmployee(Employee employee);
	
	public Employee getEmployeeById(String empCode);
	
	public List<Employee> getEmployeeBySkill(String skillName);
	
	public void addSkill(EmployeeSkill employeeSkill);

	public String getGeneratedEmployeeCode();
	
	public Employee getEmployeeByEmailId(String email);
}