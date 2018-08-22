package jdbc;

/**
 * Class to store the parent category name and count of its children categories
 * @author Ishita_Mathur
 *
 */
public class TopCategory 
{
    private String parentCategoryName;
    private int noOfChildCategories;
        
    /**
     * constructor
     * @param parentCategoryName
     * @param noOfChildCategories
     */
    public TopCategory(String parentCategoryName, int noOfChildCategories) {
        
        this.parentCategoryName = parentCategoryName;
        this.noOfChildCategories = noOfChildCategories;
    }

    /**
     * getter method for parentCategoryName
     * @return parentCategoryName
     */
    public String getParentCategoryName() {
        return parentCategoryName;
    }
    
    /**
     * setter method for parentCategoryName
     * @param parentCategoryName
     */
    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }
    
    /**
     * getter method for noOfChildCategories
     * @return noOfChildCategories
     */
    public int getNoOfChildCategories() {
        return noOfChildCategories;
    }
    
    /**
     * setter method for noOfChildCategories
     * @param noOfChildCategories
     */
    public void setNoOfChildCategories(int noOfChildCategories) {
        this.noOfChildCategories = noOfChildCategories;
    }
    
    /**
     * method to show the TopCategory
     */
    public String toString() {
        return "TopCategory [parentCategoryName=" + parentCategoryName
                + ", childCategories=" + noOfChildCategories + "]";
    }       
}