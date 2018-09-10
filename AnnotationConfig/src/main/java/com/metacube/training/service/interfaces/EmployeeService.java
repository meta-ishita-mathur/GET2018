package com.metacube.training.service.interfaces;

import java.util.List;
import com.metacube.training.model.Employee;

public interface EmployeeService
{
	List<Employee> getAllEmployee();
	boolean toggleActivation();
	boolean createEmployee(Employee employee);
}