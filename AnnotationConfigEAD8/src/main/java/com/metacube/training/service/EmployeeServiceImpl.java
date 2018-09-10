package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{	
	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Employee> getAllEmployee()
	{
		return null;
	}

	public boolean toggleActivation()
	{
		return false;
	}
	
	public boolean createEmployee(Employee employee)
	{
		employee.setEmpCode(getGeneratedEmployeeCode());
		return employeeDAO.createEmployee(employee);
	}
	
	private String getGeneratedEmployeeCode()
	{
		int integerCode;
		String newGeneratedCode = "", lastEmpCode, year;
		lastEmpCode = employeeDAO.getLastAddedEmployee().getEmpCode();
		year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
		NumberFormat numFormat = new DecimalFormat("0000");

		if(lastEmpCode == null || "".equals(lastEmpCode))
			newGeneratedCode = "E" + year + "/" + numFormat.format(0);
		else
		{
			integerCode = Integer.parseInt(lastEmpCode.split("/")[1]);
			newGeneratedCode = "E" + year + "/" + numFormat.format(integerCode + 1);
		}
		return newGeneratedCode;
	}
	
	public List<Employee> getTeamLeaders()
	{
		return employeeDAO.getTeamLeaders();
	}

	public List<Employee> getManagers()
	{
		return employeeDAO.getManagers();
	}
	
	public boolean addJobDetails(Employee employee)
	{
		return employeeDAO.addJobDetails(employee);
	}

	public Employee getEmployeeById(Employee employee)
	{
		Employee employeeInDatabase = employeeDAO.getEmployeeById(employee);
		boolean validateEmployeeFlag = false;
		if (employeeInDatabase != null)
		{
			if ((employee.getEmpCode().equals(employeeInDatabase.getEmpCode()))
					&& (employee.getPassword().equals(employeeInDatabase.getPassword())))
			{
				validateEmployeeFlag = true;
			}
		}
		System.out.println("password:" + validateEmployeeFlag);
		
		if(validateEmployeeFlag)
			return employeeInDatabase;
		else
			return null;
	}

	public Employee getEmployeeByIdString(String empCode)
	{
		Employee employee = new Employee();
		employee.setEmpCode(empCode);
		return employeeDAO.getEmployeeById(employee);
	}	
}