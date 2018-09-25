package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkill;

public interface EmployeeService
{
	public List<Employee> getAllEmployee();
	
	public boolean toggleActivation();
	
	public boolean createEmployee(Employee employee);
	
	public boolean addJobDetails(Employee employee);
	
	public Employee getEmployeeById(Employee employee);
	
	public Employee getEmployeeByIdString(String empCode);
	
	public List<Employee> getEmployeeBySkill(String skillName);
	
	public void addSkill(EmployeeSkill employeeSkill);

	public String getGeneratedEmployeeCode();
	
	public Employee getEmployeeByEmailId(String email);
	
	public boolean checkValidCredentials(String empCode, String password);
}