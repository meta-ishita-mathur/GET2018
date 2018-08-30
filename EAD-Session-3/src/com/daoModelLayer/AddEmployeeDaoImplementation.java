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

public class AddEmployeeDaoImplementation implements DAO<Employees>{
	String strSelect = "INSERT INTO Employees ( firstName,lastName,email,age) values(?,?,?,?)";
	@Override
	public List<Employees> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employees> get(Employees emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Employees t) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = Connect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Step 2: Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = conn.prepareStatement(strSelect);
			) {
			stmt.setString(1, t.getFirstName());
			stmt.setString(2, t.getLastName());
			stmt.setString(3, t.getEmail());
			stmt.setInt(4, t.getAge());
			// Step 3: Execute a SQL SELECT query, the query result
			stmt.executeUpdate();
			flag =true;
		} catch (SQLException ex) {
			flag=false;
			ex.printStackTrace();
		}
		return flag;
	}
	
	
		
}
