package com.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connect {
	
	 public static Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      String url = "jdbc:mysql://localhost:3306/employee_forum";
	      String admin = "root";
	      String password ="root";
	      conn = (Connection) DriverManager.getConnection(url, admin, password);
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }

}
