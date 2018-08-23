package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * class to perform queries on the database
 * @author Ishita_Mathur
 *
 */
public class DataAccessObject 
{
    /**
     * method to fetch all order line items (Order Id, Product Id, Order Date, Total) of the given user which are in shipped state.
     * Order Line Items are sorted by order date column in chronological order.
     * @param userId
     * @return List of OrderLineItem
     */
    public static List<OrderLineItem> fetchOrderLineItems(int userId)
    {
        List<OrderLineItem> listOfOrderLineItems = new ArrayList<OrderLineItem>();
        String query = "SELECT oi.OrderID, oi.ProductID, o.Order_Date, oi.Product_Price * oi.Product_Quantity AS total "
                + "FROM Product p INNER JOIN Order_Items oi ON p.ProductID = oi.ProductID "
                + "INNER JOIN Orders o ON o.OrderID = oi.OrderID "
                + "WHERE o.UserID = ? AND oi.Shipping_Info = 'SHIPPED' "
                + "ORDER BY o.Order_Date DESC";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, userId);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int orderId = result.getInt("OrderID");
                int productId = result.getInt("ProductID");
                String orderDate = result.getString("Order_Date");
                float total = result.getFloat("total");
                
                listOfOrderLineItems.add(new OrderLineItem(orderId, productId, orderDate, total));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }   
        return listOfOrderLineItems;
    }
    
    /**
     * method to insert images of a product using batch insert technique.
     * @param images
     * @param productId
     * @return boolean value
     */
    public static boolean insertImages(List<Image> images, int productId)
    {
        boolean inserted = false;
        String query = "INSERT INTO Product_Images(ProductID, URL) VALUES(?, ?)";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
        ){
            try 
            {
                connection.setAutoCommit(false);
                
                for (int i = 0; i < images.size(); i++)
                {
                    stmt.setInt(1, productId);
                    stmt.setString(2, images.get(i).getUrl());
                    stmt.addBatch();
                }

                int[] result = stmt.executeBatch();
                if(result.length > 0)
                    inserted = true;
                connection.commit();
            }
            catch (SQLException exception)
            {
                exception.printStackTrace();
                connection.rollback();
            }
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }   
        return inserted;
    }
    
    /**
     * method to set all those products as inactive which were not ordered by any Shopper in last 1 year.
     * @return number of products set as inactive
     */
    public static int markInactive()
    {
        int noOfUpdates = 0;
        String query = "UPDATE Product "
                + "SET Is_Active = FALSE "
                + "WHERE ProductID NOT IN "
                + "(SELECT DISTINCT ProductID "
                + "FROM Order_Items OI INNER JOIN Orders O ON OI.OrderID = O.OrderID"
                + "WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 1 YEAR)));";
        
        try
        (
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            
        ){
            try
            {
                noOfUpdates = stmt.executeUpdate();
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        System.out.println(noOfUpdates);
        return noOfUpdates;
    }
    
    /**
     * method to select the category title of all top parent categories sorted alphabetically and the count of their child categories.
     * @return list of TopCategory(parentCategoryName, noOfChildCategories)
     */
    public static List<TopCategory> countChildren()
    {
        List<TopCategory> listOfTopCategories = new ArrayList<TopCategory>();
        String query1 = "CREATE FUNCTION count_children(parent_id INTEGER) "
                + "RETURNS INTEGER NOT DETERMINISTIC "
                + "BEGIN "
                + "DECLARE count INTEGER; "
                + "SELECT count(CategoryID) INTO count "
                + "FROM Product_Category, "
                + "(SELECT @parent_set := parent_id) initialisation "
                + "WHERE find_in_set(Parent_CategoryID, @parent_set) AND @parent_set := concat(@parent_set, ',', CategoryID); "
                + "RETURN count; "
                + "END";
        
        String query2 = "SELECT Category_Name, count_children(CategoryID) AS children_count "
                + "FROM Product_Category "
                + "WHERE Parent_CategoryID IS NULL "
                + "ORDER BY Category_Name ";
        
        String query3 = "DROP FUNCTION IF EXISTS count_children";
        
        try
        (
            Connection connection = getConnection();
           
            PreparedStatement stmt1 = connection.prepareStatement(query1);
            PreparedStatement stmt2 = connection.prepareStatement(query2);
            PreparedStatement stmt3 = connection.prepareStatement(query3);
        )
        {
            stmt1.execute(); //create the function
            ResultSet result = stmt2.executeQuery();
            
            while(result.next())
            {
                String parentCategoryName = result.getString("Category_Name");
                int noOfChildCategories = result.getInt("children_count");
                
                listOfTopCategories.add(new TopCategory(parentCategoryName, noOfChildCategories));
            }        
            stmt3.execute();//drop the function after use
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        return listOfTopCategories;
    }
    
    /**
     * method to create a connection with the database
     * @return connection 
     */
    private static Connection getConnection()
    {
        Connection connection = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/StoreFront";
            connection = DriverManager.getConnection(url, "root", "ishu1996");
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
            System.exit(1);
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }   
        return connection;
    }   
}
