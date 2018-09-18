package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{	
	@Autowired
    	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
    	private SkillRepository<Skill> skillRepository;
	
	public Employee getEmployeeById(String empCode)
	{
		return employeeRepository.findOne(empCode);
	}
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}

	public boolean createEmployee(Employee employee)
	{
		int[] skills = employee.getSkills();
		return employeeRepository.save(employee);
	}

	public String getGeneratedEmployeeCode()
	{
		int integerCode;
		String newGeneratedCode = "", lastEmpCode, year;
		lastEmpCode = employeeRepository.getLastAddedEmployee().getEmpCode();
		year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
		NumberFormat numFormat = new DecimalFormat("0000");

		if (lastEmpCode == null || "".equals(lastEmpCode))
			newGeneratedCode = "E" + year + "/" + numFormat.format(0);
		else {
			integerCode = Integer.parseInt(lastEmpCode.split("/")[1]);
			newGeneratedCode = "E" + year + "/"
					+ numFormat.format(integerCode + 1);
		}
		return newGeneratedCode;
	}

	public Employee getEmployeeByEmailId(String email)
	{
		Employee employee = new Employee();
		employee.setEmail(email);
		return employeeRepository.getEmployeeByEmailId(employee);
	}
	
	public List<Employee> getEmployeeBySkill(String skillName)
	{
		return employeeRepository.getEmployeesBySkill(skillName);
	}
	
	public void addSkill(EmployeeSkill employeeSkill)
	{
		Employee newEmployee = employeeRepository.findOne(employeeSkill.getEmpCodeTable());
		List<Skill> skillSet = skillRepository.findAll();
		employeeRepository.save(newEmployee);
	}
}
