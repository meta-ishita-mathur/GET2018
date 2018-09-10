package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String GET_LAST_EMPLOYEE = "SELECT * FROM employee ORDER BY emp_code DESC LIMIT 1;";
	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(emp_Code, first_Name, last_Name, dob, gender,"
			+ "email_Id) values(?,?,?,?,?,?)";

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
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
				employee.getEmpCode(), employee.getFirstName(),
				employee.getLastName(), employee.getDob(),
				employee.getGender(), employee.getEmailId()) > 0;
	}

	public Employee getLastAddedEmployee()
	{
		return jdbcTemplate.queryForObject(GET_LAST_EMPLOYEE, new EmployeeMapper());
	}
}