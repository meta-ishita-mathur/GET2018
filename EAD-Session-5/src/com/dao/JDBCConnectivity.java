package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectivity
{
	/**
	 * method to create a connection with the database
	 * @return connection 
	 */
	public static Connection getConnection()
	{
		Connection connection = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/rest";
			connection = DriverManager.getConnection(url, "root", "ishu1996");
		}
		catch(ClassNotFoundException exception)
		{
			exception.printStackTrace();
			System.exit(1);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.exit(2);
		}
		return connection;
	}
}