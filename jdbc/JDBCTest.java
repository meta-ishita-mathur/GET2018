package jdbc;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class JDBCTest {

    /**
     * test case for insertImages
     */
    @Test
    public void insertImagesTest() 
    {        
        List<Image> images = new ArrayList<Image>();
        images.add(new Image("image.com/id201"));
        images.add(new Image("image.com/id202"));
        images.add(new Image("image.com/id203"));
        images.add(new Image("image.com/id204"));
        images.add(new Image("image.com/id205"));
        
        assertTrue(DataAccessObject.insertImages(images, 1));
    }
    
    /**
     * test case for markInactive
     */
    @Test
    public void markInactiveTest()
    {        
        assertEquals(1, DataAccessObject.markInactive());
    } 
    
    /**
     * test case for fetchOrderLineItems
     */
    @Test
    public void fetchOrderLineItemsTest()
    {
        List<OrderLineItem> result = DataAccessObject.fetchOrderLineItems(1);
        List<OrderLineItem> expected = new ArrayList<OrderLineItem>();
        expected.add(new OrderLineItem(4, 3, "2018-08-22", 13999.00f));
        
        assertEquals(expected.size(), result.size());
        
        for(OrderLineItem item: result)
            System.out.println(item);
    }
       
    /**
     * test case for countChildren
     */
    @Test
    public void countChildrenTest()
    {
        List<TopCategory> result = DataAccessObject.countChildren();
        List<TopCategory> expected = new ArrayList<TopCategory>();
        expected.add(new TopCategory("CLOTHING", 1));
        expected.add(new TopCategory("ELECTRONICS", 2));
        expected.add(new TopCategory("WOMEN UTILITY", 0));
        
        assertEquals(expected.size(), result.size());
        
        for(TopCategory category: result)
            System.out.println(category);
    }
}