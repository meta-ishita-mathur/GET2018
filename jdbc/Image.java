package jdbc;

/**
 * Class to store the attributes of image
 * @author Ishita_Mathur
 *
 */
public class Image
{
    private String url;
    
    /**
     * constructor
     * @param url
     */
    public Image(String url) {
        this.url = url;
    }
    
    /**
     * getter method for url
     * @return url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * setter method for url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}