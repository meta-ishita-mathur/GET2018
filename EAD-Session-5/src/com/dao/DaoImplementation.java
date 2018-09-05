package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Advertisement;
import com.model.Category;

/**
 * Implementation of Dao
 */
public class DaoImplementation implements BasicDAO
{
	/**
	 * method to create a new category
	 * @param category
	 * @return boolean value
	 */
	public boolean createCategory(Category category)
	{
		boolean isCreated = false;

		try
		(
			Connection connection = JDBCConnectivity.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.CREATE_CATEGORY);
		){
			statement.setString(1, category.getCategoryName());
			if(statement.executeUpdate() > 0)
				isCreated = true;
		}
		catch (SQLException exception) 
		{
			exception.printStackTrace();
		}
		return isCreated;
	}
	
	/**
	 * method to get all categories from database
	 * @return list of category
	 */
	public List<Category> getAllCategories()
	{
		int categoryId;
		String categoryName;
		List<Category> categoryList = new ArrayList<Category>();

		try
		(
			Connection connection = JDBCConnectivity.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.GET_CATEGORIES);
		){
			ResultSet result = statement.executeQuery();

			while(result.next())
			{
				categoryId = result.getInt("id");
				categoryName = result.getString("category_name");
				categoryList.add(new Category(categoryId, categoryName));
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return categoryList;
	}
	
	/**
     	 * method to create a new advertisement
     	 * @param advertisement
     	 * @return boolean value
     	 */
    	public boolean createAdvertisement(Advertisement advertisement)
     	{
    		boolean isCreated = false;
    		try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.CREATE_ADVERTISEMENT);
        	){
    			statement.setString(1, advertisement.getTitle());
    			statement.setString(2, advertisement.getDescription());
    			statement.setInt(3, advertisement.getCategoryId());
    			if(statement.executeUpdate() > 0)
    				isCreated = true;
        	}
        	catch (SQLException exception) 
        	{
            		exception.printStackTrace();
        	}
    		return isCreated;
    	}
    
    	/**
     	 * method to get all the advertisements from the database
     	 * @return list of advertisement
     	 */
    	public List<Advertisement> getAllAdvertisements()
    	{
    		int advertisementId, categoryId;
    		String advertisementTitle, advertisementDescription;
       	 	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
        
        	try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS);
        	){
            		ResultSet result = statement.executeQuery();
            
            		while(result.next())
            		{
                		advertisementId = result.getInt("id");
                		advertisementTitle = result.getString("title");
                		advertisementDescription = result.getString("description");
                		categoryId = result.getInt("category_id");
                		advertisementList.add(new Advertisement(advertisementId, categoryId, advertisementTitle, advertisementDescription));
            		}
        	}
        	catch(Exception exception)
        	{
            		exception.printStackTrace();
        	}
        	return advertisementList;
    	}
    
    	/**
     	 * method to get all the advertisements of a particular category from the database
     	 * @param categoryId
     	 * @return list of advertisement
     	 */
	public List<Advertisement> getAdvertisementsByCategory(int categoryId)
	{
		int advertisementId, categoryIdOfAdvertisement;
		String title, description;
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		try
		(
		    Connection connection = JDBCConnectivity.getConnection();
		    PreparedStatement statement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS_BY_CATEGORY);
		){
		    ResultSet result = statement.executeQuery();
		    statement.setInt(1, categoryId);

		    while(result.next())
		    {
			advertisementId = result.getInt("id");
			title = result.getString("title");
			description = result.getString("description");
			categoryIdOfAdvertisement = result.getInt("category_id");
			advertisementList.add(new Advertisement(advertisementId, categoryIdOfAdvertisement, title, description));
		    }
		}
		catch(Exception exception)
		{
		    exception.printStackTrace();
		}
		return advertisementList;
	}
    
	/**
	 * method to update the title of an existing advertisement
	 * @param advertisement
	 * @return boolean value
	 */
	public boolean updateAdvertisementName(Advertisement advertisement)
	{
		boolean isUpdated = false;

		try
		(
		    Connection connection = JDBCConnectivity.getConnection();
		    PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ADVERTISEMENT_NAME);
		){
			statement.setString(1, advertisement.getTitle());
			statement.setInt(2, advertisement.getId());
			if(statement.executeUpdate() > 0)
				isUpdated = true;
		}
		catch (SQLException exception) 
		{
		    exception.printStackTrace();
		}
		return isUpdated;
	}

	/**
     	 * method to update the name of an existing category
     	 * @param category
     	 * @return boolean value
     	 */
	public boolean updateCategoryName(Category category)
	{
		boolean isUpdated = false;
		
		try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_CATEGORY_NAME);
        	){
			statement.setString(1, category.getCategoryName());
			statement.setInt(2, category.getId());
			if(statement.executeUpdate() > 0)
				isUpdated = true;
        	}
        	catch (SQLException exception) 
        	{
            		exception.printStackTrace();
        	}
		return isUpdated;
	}

	/**
     	 * method to delete the given advertisement
     	 * @param advertisementId
     	 * @return boolean value
     	 */
	public boolean deleteAdvertisement(int advertisementId)
	{
		boolean isDeleted = false;
		
		try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.DELETE_ADVERTISEMENT);
        	){
			statement.setInt(1, advertisementId);
			if(statement.executeUpdate() > 0)
				isDeleted = true;
        	}
        	catch (SQLException exception) 
        	{
            		exception.printStackTrace();
        	}
		return isDeleted;
	}
	
	/**
     	 * method to check if the given category exists in the database
     	 * @param categoryId
     	 * @return boolean value
     	 */
    	public boolean categoryExist(int categoryId)
    	{
        	boolean exists = false;
        
        	try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.GET_CATEGORY_NAME);
        	){
            		statement.setInt(1, categoryId);
            		ResultSet result = statement.executeQuery();
            
            		if(result.next())
                	exists = true;
        	}
        	catch(Exception exception)
        	{
            		exception.printStackTrace();
        	}
        	return exists;
    	}
    
    	/**
     	 * method to check if the given advertisement exists in the database
     	 * @param advertisementId
     	 * @return boolean value
     	 */
    	public boolean advertisementExist(int advertisementId)
    	{
    		boolean exists = false;
        
        	try
        	(
            		Connection connection = JDBCConnectivity.getConnection();
            		PreparedStatement statement = connection.prepareStatement(Queries.GET_ADVERTISEMENT_TITLE);
        	){
            		statement.setInt(1, advertisementId);
            		ResultSet result = statement.executeQuery();
            
            		if(result.next())
                		exists = true;
        	}
        	catch(Exception exception)
        	{
            		exception.printStackTrace();
        	}
        	return exists;
    	}
}
