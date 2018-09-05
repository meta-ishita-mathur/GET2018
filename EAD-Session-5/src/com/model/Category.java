package com.model;

/**
 * class to store the details of a category
 */
public class Category
{
	private int id;
    	private String categoryName;
    
    	/**
     	 * default constructor
     	 */
    	public Category(){};

	/**
	 * parameterized constructor
	 * @param id
         * @param categoryName
	 */
	public Category(int id, String categoryName)
	{
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
    
    	/**
     	 * @return the id
     	 */
    	public int getId()
    	{
        	return id;
    	}
    
    	/**
     	 * @param id the id to set
     	 */
    	public void setId(int id)
    	{
        	this.id = id;
    	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName()
	{
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
}
