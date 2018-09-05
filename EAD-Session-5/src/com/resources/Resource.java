package com.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.dao.BasicDAO;
import com.dao.DaoImplementation;
import com.model.Advertisement;
import com.model.Category;

/**
 * class used to perform operations
 */
@Path("/advertise")
public class Resource
{
	BasicDAO dao = new DaoImplementation();
    
    	/**
     	* method to create a new category
     	* @param category
     	*/
    	@Path("/categories/create")
    	@POST
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void createCategory(Category category)
    	{
        	if(!dao.createCategory(category))
            		System.out.println("This category already exists!");
    	}
    
    	/**
     	* method to retrieve all the categories
     	* @return List of categories
     	*/
    	@Path("/categories")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<Category> getCategories()
    	{
        	return dao.getAllCategories();
    	}
    
    	/**
     	* method to create a new advertisement
     	* @param categoryId
     	* @param advertisement
     	*/
    	@Path("/categories/{id}/advertisements/create")
    	@POST
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void createAdvertisement(@PathParam("id") int categoryId, Advertisement advertisement)
    	{
        	if(advertisement.getCategoryId() != categoryId)
            		System.out.println("category IDs don't match");
        
        	else if(!dao.categoryExist(categoryId))
            		System.out.println("category does not exist");
        
        	else if(!dao.createAdvertisement(advertisement))
        		System.out.println("This advertisement already exists!");
    	}    
    
    	/**
     	* method to retrieve all advertisements
     	* @return list of advertisement
     	*/
    	@Path("/advertisements")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<Advertisement> getAllAdvertisements()
    	{
        	return dao.getAllAdvertisements();
    	}
    
    	/**
     	* method to retrieve all advertisements of a particular category
     	* @param categoryId
     	* @return list of advertisement
     	*/
    	@Path("/categories/{id}/advertisements")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<Advertisement> getAdvertisementsByCategoryId(@PathParam("id") int categoryId)
    	{
        	List<Advertisement> advertisements = new ArrayList<>();
        
        	if(!dao.categoryExist(categoryId))
            		System.out.println("category does not exist");
        	else
            		advertisements = dao.getAdvertisementsByCategory(categoryId);
        
        	return advertisements;
    	}
    
    	/**
     	* method to update the title of an existing advertisement
     	* @param categoryId
     	* @param advertisementId
     	* @param advertisement
     	*/
    	@Path("/categories/{category_id}/advertisements/{advertisement_id}/update")
    	@PUT
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void updateAdvertisementName(@PathParam("category_id") int categoryId, @PathParam("advertisement_id") int advertisementId, Advertisement advertisement)
    	{   
    		if(!dao.categoryExist(categoryId))
            		System.out.println("category does not exist");
    	
    		else if(advertisement.getCategoryId() != categoryId)
            		System.out.println("category IDs don't match");
    	
    		else if(advertisement.getId() != advertisementId)
            		System.out.println("advertisement IDs don't match");
        
    		else if(!dao.advertisementExist(advertisementId))
        		System.out.println("advertisement does not exist");
        
    		else if(!dao.updateAdvertisementName(advertisement))
    			System.out.println("advertisement is not updated");
    	}
    
    	/**
     	* method to update the name of an existing category
     	* @param categoryId
     	* @param category
     	*/
    	@Path("/categories/{id}/update")
    	@PUT
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void updateCategoryname(@PathParam("id") int categoryId, Category category)
    	{
    		if(!dao.categoryExist(categoryId))
            		System.out.println("category does not exist");
    	
    		else if(!dao.updateCategoryName(category))
    			System.out.println("category is not updated");
    	}
    
    	/**
     	* method to delete an existing advertisement
     	* @param categoryId
     	* @param advertisementId
     	*/
    	@Path("/categories/{category_id}/advertisements/{advertisement_id}/delete")
    	@DELETE
    	public void deleteAdvertisement(@PathParam("category_id") int categoryId, @PathParam("advertisement_id") int advertisementId)
    	{
    		if(!dao.categoryExist(categoryId))
            		System.out.println("category does not exist");
        
    		else if(!dao.advertisementExist(advertisementId))
        		System.out.println("advertisement does not exist");
        
    		else if(!dao.deleteAdvertisement(advertisementId))
    			System.out.println("advertisement is not deleted");
    	}
}
