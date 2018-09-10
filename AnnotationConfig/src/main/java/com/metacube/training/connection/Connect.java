package com.metacube.training.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Connect
{
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee_portal";
			String admin = "root";
			String password ="ishu1996";
			connection = (Connection) DriverManager.getConnection(url, admin, password);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}