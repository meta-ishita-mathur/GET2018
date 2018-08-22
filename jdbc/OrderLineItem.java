package jdbc;

/**
 * Class to store the Order Line Item
 * @author Ishita_Mathur
 *
 */
public class OrderLineItem 
{
    private int orderId;
    private int productId;
    private String orderDate;
    private float total;
        
    /**
     * constructor
     * @param orderId
     * @param productId
     * @param orderDate
     * @param total
     */
    public OrderLineItem(int orderId, int productId, String orderDate, float total) {
        
        this.orderId = orderId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.total = total;
    }
    
    /**
     * getter method for orderId
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }
    
    /**
     * setter method for orderId
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    /**
     * getter method for productId
     * @return productId
     */
    public int getProductId() {
        return productId;
    }
    
    /**
     * setter method for productId
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    /**
     * getter method for orderDate
     * @return orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }
    
    /**
     * setter method for orderDate
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    /**
     * getter method for total
     * @return total
     */
    public float getTotal() {
        return total;
    }
        
    /**
     * setter method for total
     * @param total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * method to show the OrderLineItem
     */
    public String toString() {
        return "OrderLineItem [orderId=" + orderId + ", productId=" + productId
                + ", orderDate=" + orderDate + ", total=" + total + "]";
    }       
}