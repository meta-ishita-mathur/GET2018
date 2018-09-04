package com.model;

/**
 * class to store the details of an advertisement
 */
public class Advertisement
{
	private int id, categoryId;
	private String title, description;

	/**
	 * default constructor
	 */
	public Advertisement(){};

	/**
	 * parameterized constructor
	 * @param id
	 * @param categoryId
	 * @param title
	 * @param description
	 */
	public Advertisement(int id, int categoryId, String title, String description)
	{
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
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
	 * @return the category_id
	 */
	public int getCategoryId()
	{
		return categoryId;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
}