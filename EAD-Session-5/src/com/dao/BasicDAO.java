package com.dao;

import java.util.List;
import com.model.Advertisement;
import com.model.Category;

/**
 * interface to perform various operations on the database
 */
public interface BasicDAO
{
	public boolean createCategory(Category category);

	public List<Category> getAllCategories();

	public boolean createAdvertisement(Advertisement advertisement);

	public List<Advertisement> getAllAdvertisements();
	
	public List<Advertisement> getAdvertisementsByCategory(int categoryId);

	public boolean updateAdvertisementName(Advertisement advertisement);

	public boolean updateCategoryName(Category category);

	public boolean deleteAdvertisement(int advertisementId);

	public boolean categoryExist(int categoryId);

	public boolean advertisementExist(int advertisementId);
}