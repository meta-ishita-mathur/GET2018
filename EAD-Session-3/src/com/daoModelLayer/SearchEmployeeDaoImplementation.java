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

public class SearchEmployeeDaoImplementation implements DAO<Employees>{
	List<Employees> employeeList = new ArrayList<Employees>();
	private String firstName;
	private String lastName;
	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Employees> get(Employees t) {
		PreparedStatement stmt = null;
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = Connect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				// Step 2: Allocate a 'Statement' object in the Connection
			){
		if(t.getLastName() == "")
		{	
			firstName = t.getFirstName();
			lastName = t.getFirstName();
			String query = "SELECT firstName,lastName,email,age FROM Employees WHERE firstName like '%"+firstName+"%' OR lastName like '%"+lastName+"%'";
			stmt = conn.prepareStatement(query);
			ResultSet rset = stmt.executeQuery();
			addToList(rset);
		}
		else
		{
			firstName = t.getFirstName();
			lastName = t.getLastName();
			String query = "SELECT firstName,lastName,email,age FROM Employees WHERE firstName like '%"+firstName+"%' AND lastName like '%"+lastName+"%'";
			stmt = conn.prepareStatement(query);
			ResultSet rset1 = stmt.executeQuery();
			addToList(rset1);
		}
	 }catch (SQLException ex) {
		ex.printStackTrace();
	}finally{
		try{
				stmt.close();
		}catch(SQLException e)
		{
			e.getMessage();
		}
	}
		return  employeeList;
	}

	@Override
	public boolean add(Employees t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Employees get(String email){
		String query = "SELECT firstName, lastName, email, age FROM employees WHERE email = '"+ email + "'";
		Employees emp = null;
		try (Connection conn = Connect.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();) {
			rset.next();
			String firstName = rset.getString("firstName");
				String lastName = rset.getString("lastName");
				int age = rset.getInt("age");
				Employees employee = new Employees(firstName, lastName, email,
						age);
				emp = employee;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	
	public boolean update(Employees emp){
		String query  = "UPDATE employees SET firstName =  ? , lastName = ? , email = ? , age = ? WHERE email = ? ;";
		boolean isEmployeeUpdateFalg = false;
		
		try(Connection conn = Connect.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);	
			){
			pstmt.setString(1,emp.getFirstName());
			pstmt.setString(2,emp.getLastName());
			pstmt.setString(3,emp.getEmail());
			pstmt.setInt(4,emp.getAge());

			pstmt.setString(5,emp.getEmail());

			isEmployeeUpdateFalg = pstmt.executeUpdate()==0?false:true;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return isEmployeeUpdateFalg;
	}
	
	public boolean addToList (ResultSet rsetOptional)
	{
		boolean flag = false;
		try{
		while (rsetOptional.next()) { // Move the cursor to the next row, return false if no more row
			String firstName = rsetOptional.getString("firstName");
			String lastName = rsetOptional.getString("lastName");
			String email = rsetOptional.getString("email");
			int age = rsetOptional.getInt("age");
			Employees object = new Employees(firstName,lastName,email,age);
			if(!employeeList.contains(object))
					{
						employeeList.add(object);
					}
		}
		flag = true;
		}catch(SQLException e)
		{
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
}
