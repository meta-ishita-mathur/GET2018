package com.daoModelLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connection.Connect;
import com.dao.DAO;
import com.model.Employees;
import com.mysql.jdbc.Connection;

/**
 * class to search the employees from the database having name like the given text
 */
public class SearchEmployeeDaoImplementation implements DAO<Employees>
{
	List<Employees> employeeList = new ArrayList<Employees>();
	private String firstName, lastName;
	
	public List getAll()
	{
		return null;
	}
	
	public List<Employees> get(Employees employee)
	{
		PreparedStatement statement = null;
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection connection = Connect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
		    )
		{
			if(employee.getLastName() == "")
			{	
				firstName = employee.getFirstName();
				lastName = employee.getFirstName();
				String query = "SELECT firstName, lastName, email, age FROM Employees WHERE firstName LIKE '%"+firstName+"%' OR lastName LIKE '%"+lastName+"%'";
				statement = connection.prepareStatement(query);
				ResultSet firstSet = statement.executeQuery();
				addToList(firstSet);
			}
			else
			{
				firstName = employee.getFirstName();
				lastName = employee.getLastName();
				String query = "SELECT firstName, lastName, email, age FROM Employees WHERE firstName LIKE '%"+firstName+"%' AND lastName LIKE '%"+lastName+"%'";
				statement = connection.prepareStatement(query);
				ResultSet secondSet = statement.executeQuery();
				addToList(secondSet);
			}
	 	}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(SQLException exception)
			{
				exception.getMessage();
			}
		}
		return  employeeList;
	}

	public boolean add(Employees employee)
	{
		return false;
	}
	
	public Employees get(String email)
	{
		String query = "SELECT firstName, lastName, email, age FROM employees WHERE email = '"+ email + "'";
		String firstName, lastName;
		int age;
		Employees employee, newEmployee = null;
		
		try (Connection connection = Connect.getConnection();
		     PreparedStatement statement = connection.prepareStatement(query);
		     ResultSet firstSet = statement.executeQuery();
		    )
		{
			firstSet.next();
			firstName = firstSet.getString("firstName");
			lastName = firstSet.getString("lastName");
			age = firstSet.getInt("age");
			employee = new Employees(firstName, lastName, email, age);
			newEmployee = employee;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return newEmployee;
	}
	
	public boolean update(Employees employee)
	{
		String query = "UPDATE employees SET firstName = ?, lastName = ?, email = ?, age = ? WHERE email = ?;";
		boolean isEmployeeUpdateFalg = false;
		
		try(Connection connection = Connect.getConnection();
		    PreparedStatement statement = connection.prepareStatement(query);
		   )
		{
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getAge());
			statement.setString(5, employee.getEmail());
			isEmployeeUpdateFalg = statement.executeUpdate() == 0 ? false : true;
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return isEmployeeUpdateFalg;
	}
	
	public boolean addToList (ResultSet setOptional)
	{
		boolean addFlag = false;
		String firstName, lastName, email;
		int age;
		Employees employee = null;
		
		try
		{
			while (setOptional.next())
			{ 	// Move the cursor to the next row, return false if no more row
				firstName = setOptional.getString("firstName");
				lastName = setOptional.getString("lastName");
				email = setOptional.getString("email");
				age = setOptional.getInt("age");
				employee = new Employees(firstName, lastName, email, age);
				if(!employeeList.contains(employee))
				{
					employeeList.add(employee);
				}
			}
			addFlag = true;
		}
		catch(SQLException exception)
		{
			addFlag = false;
			exception.printStackTrace();
		}
		return addFlag;
	}
}
