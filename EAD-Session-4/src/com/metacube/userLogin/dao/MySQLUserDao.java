package com.metacube.userLogin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.metacube.userLogin.dao.connection.Connect;
import com.metacube.userLogin.models.User;

public class MySQLUserDao implements UserDao
{
	private static MySQLUserDao mySQLUserDao = new MySQLUserDao();

	private MySQLUserDao()
	{

	}

	public static MySQLUserDao getInstance()
	{
		return mySQLUserDao;
	}

	public List<User> getAll()
	{
		List<User> listOfUserData = new ArrayList<User>();
		String query = Queries.SELECT_ALL;
		try
		(
			Connection connection = Connect.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result =  statement.executeQuery();	
		){
			while(result.next())
			{
				int userId, age;
				String firstName, lastName, mobile, email, password, orgName, imageUrl;
				
				userId = result.getInt("user_id");
				firstName = result.getString("fisrt_name");
				lastName = result.getString("last_name");
				age  = result.getInt("age");
				mobile = result.getString("mobile_number");
				email = result.getString("email");
				password = result.getString("password");
				orgName = result.getString("org_name");
				imageUrl = result.getString("image_url");
				Date date = result.getDate("dob");

				User user = new User(firstName, lastName,age, date, mobile, email, password, orgName);
				user.setImageUrl(imageUrl);
				user.setId(userId);
				listOfUserData.add(user);
			}
		}
		catch(Exception e)
		{
			return null;
		}
		return listOfUserData;
	}

	public boolean insert(User entity)
	{
		String query = Queries.INSERT_USER; 
		int rowInserted= 0;

		try
		(
			Connection connection = Connect.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(query);
		){
			statement.setString(1, entity.getFirstName());
			statement.setString(2, entity.getLastName());
			statement.setInt(3, entity.getAge());
			statement.setDate(4, entity.getDob());
			statement.setString(5, entity.getMobileNumber());
			statement.setString(6, entity.getEmail());
			statement.setString(7, entity.getPassword());
			statement.setString(8, entity.getOrgName());
			rowInserted = statement.executeUpdate();
		}
		catch(Exception error)
		{
			rowInserted = 2;
		}
		return (rowInserted == 1);
	}
	
	public boolean update(User user)
	{
		String query = Queries.UPDTAE_USER;
		int rowUpdated= 0;

		try
		(
			Connection connection = Connect.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(query);
		){
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getAge());
			statement.setString(4, user.getMobileNumber());
			statement.setString(5, user.getOrgName());
			statement.setInt(6, user.getId());
			rowUpdated = statement.executeUpdate();
		}
		catch(Exception error)
		{
			rowUpdated = 2;
			System.out.println(error.getMessage());
		}
		return (rowUpdated == 1);
	}

	public boolean delete(User user)
	{
		return false;
	}

	public List<User> getFriends(User user)
	{
		List<User> friendList = new ArrayList<User>();
		String query = Queries.SELECT_FRIENDS; 
		try
		(
			Connection connection = Connect.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
		){
			statement.setString(1, user.getOrgName());
			statement.setInt(2, user.getId());
			ResultSet result =  statement.executeQuery();

			while(result.next())
			{
				int userId, age;
				String firstName, lastName, mobile, temp_email, password, orgName, imageUrl;
				
				userId = result.getInt("user_id");
				firstName = result.getString("first_name");
				lastName = result.getString("last_name");
				age  = result.getInt("age");
				mobile = result.getString("mobile_number");
				temp_email = result.getString("email");
				password = result.getString("password");
				orgName = result.getString("org_name");
				imageUrl = result.getString("image_url");
				Date date = result.getDate("dob");

				User tempUser = new User(firstName, lastName,age, date, mobile, temp_email, password, orgName);
				tempUser.setImageUrl(imageUrl);
				tempUser.setId(userId);
				friendList.add(tempUser);
			}
		}
		catch(Exception error)
		{
			friendList = null;
		}
		return friendList;
	}

	public User getUser(String email)
	{
		List<User> listOfUserData = new ArrayList<User>();
		String query = "SELECT user_id, first_name, last_name, age, dob, mobile_number, email, password, org_name, image_url FROM user_info WHERE email LIKE '" + email + "';";
		try
		(
			Connection connection = Connect.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result =  statement.executeQuery();	
		){
			while(result.next())
			{
				int userId, age;
				String firstName, lastName, mobile, temp_email, password, orgName, imageUrl;
				
				userId = result.getInt("user_id");
				firstName = result.getString("first_name");
				lastName = result.getString("last_name");
				age  = result.getInt("age");
				mobile = result.getString("mobile_number");
				temp_email = result.getString("email");
				password = result.getString("password");
				orgName = result.getString("org_name");
				imageUrl = result.getString("image_url");
				Date date = result.getDate("dob");

				User user = new User(firstName, lastName,age, date, mobile, temp_email, password, orgName);
				user.setImageUrl(imageUrl);
				user.setId(userId);
				listOfUserData.add(user);
			}
		}
		catch(Exception error)
		{
			return null;
		}
		return listOfUserData.size() == 0 ? null : listOfUserData.get(0);
	}

	public boolean insertImage(String imageUrl, User user)
	{
		String query = Queries.INSERT_IMAGE;
		int rowUpdated= 0;

		try
		(
			Connection connection = Connect.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(query);
		){
			statement.setString(1, imageUrl);
			statement.setInt(2, user.getId());
			rowUpdated = statement.executeUpdate();
		}
		catch(Exception error)
		{
			rowUpdated = 2;
			System.out.println(error.getMessage());
		}
		return (rowUpdated == 1);
	}
}