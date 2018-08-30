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
import com.mysql.jdbc.ResultSet;

/**
 * class to retrieve all the employee details from the database
 */
public class ShowEmployeeDaoImplementation implements DAO<Employees>
{
	private List<Employees> resultList = new ArrayList<Employees>();
	String strSelect = "Select * From Employees";

	/**
     	 * method to retrieve all the employee details from the database
     	 * @return listofEmployees
     	 */
	public List<Employees> getAll()
	{
		try (// Step 1: Allocate a database 'Connection' object
		     Connection connection = Connect.getConnection();
		     // In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

		     // Step 2: Allocate a 'Statement' object in the Connection
		     PreparedStatement statement = connection.prepareStatement(strSelect);
		    )
		{
			// Step 3: Execute a SQL SELECT query, the query result
			ResultSet result = (ResultSet) statement.executeQuery();
			int rowCount = 0, age;
			String firstName, lastName, email;
			while (result.next())
			{ 
				// Move the cursor to the next row, return false if no more row
				firstName = result.getString("firstName");
				lastName = result.getString("lastName");
				email = result.getString("email");
				age = result.getInt("age");
				Employees employee = new Employees(firstName, lastName, email, age);
				resultList.add(employee);
				// System.out.println(rset.getFetchSize());
				++rowCount;
			}
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		return resultList;
	}

	public List<Employees> get(Employees employee)
	{
		return null;
	}

	public boolean add(Employees employee)
	{
		return false;
	}
}
