package com.daoModelLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.connection.Connect;
import com.dao.DAO;
import com.model.Employees;
import com.mysql.jdbc.Connection;

/**
 * class to add an employee to the database
 */
public class AddEmployeeDaoImplementation implements DAO<Employees>
{
	String strSelect = "INSERT INTO Employees (firstName, lastName, email, age) values(?, ?, ?, ?)";

	public List<Employees> getAll()
	{
		return null;
	}

	public List<Employees> get(Employees employee)
	{
		return null;
	}
	
	 /**
     	  * method to add an employee to the database
     	  * @param employee
     	  * @return boolean value
     	  */
	public boolean add(Employees employee)
	{
		boolean flagAdd = false;
		try (// Step 1: Allocate a database 'Connection' object
			Connection connection = Connect.getConnection();
		     // In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
		     // Step 2: Allocate a 'Statement' object in the Connection
			PreparedStatement statement = connection.prepareStatement(strSelect);
			)
		{
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getAge());
			// Step 3: Execute a SQL SELECT query, the query result
			statement.executeUpdate();
			flagAdd = true;
		}
		catch (SQLException exception)
		{
			flagAdd = false;
			exception.printStackTrace();
		}
		return flagAdd;
	}
}
