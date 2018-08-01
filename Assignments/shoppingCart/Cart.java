package shoppingCart;

import java.util.ArrayList;

public class Cart 
{
	ArrayList<Product> cartItems = new ArrayList<Product>();
	
	public void addProduct(int productId, String name, double price, int quantity)
    	{
    		int updateList = 0, newQuantity;
    		Product item;
		for(Product product : cartItems)
		{
			if(product.getName().equals(name))
			{
				updateList = 1;
				newQuantity = product.getQuantity();
				product.setQuantity(quantity + newQuantity);
				break;
			}
		}
		if(updateList == 0)
		{
			item = new Product(productId, name, price, quantity);
			cartItems.add(item);
		}
       
    }

    public void removeProduct (int productId) 
    {
    	for(Product product : cartItems)
    	{
    		if(productId == product.getProductId())
			{
				cartItems.remove(product);
				break;
			}
    	}
        
    }

    public void generateBill()
	{
		double sum = 0;
		System.out.println("productId\t\tname\t\tprice\t\tquantity\ttotal price");
		for(Product product : cartItems)
		{
			product.display();
			sum += product.totalPrice();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
	}

}
