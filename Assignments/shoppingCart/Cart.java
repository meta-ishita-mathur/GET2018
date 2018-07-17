package shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart 
{
    List<Product> cartItems = new ArrayList<Product>();
    
    public void addProduct(int pid,String name,double price,int quantity)
    {
    	int update = 0;
		for(Product p : cartItems)
		{
			if(p.getName().equals(name))
			{
				update = 1;
				int q = p.getQuantity();
				p.setQuantity(quantity + q);
				break;
			}
		}
		if(update == 0)
		{
		Product item = new Product(pid,name, price, quantity);
		cartItems.add(item);
		}
       
    }

   

    public void removeProduct(int pid) 
    {
    	for(Product p:cartItems)
    	{
    		if(pid==p.getPid())
			{
				cartItems.remove(p);
				break;
			}
    	}
        
    }

    public void generateBill()
	{
		double sum=0;
		System.out.println("pid\t\tname\t\tprice\t\tquantity\ttotal price");
		for(Product p:cartItems)
		{
			p.display();
			sum += p.totalPrice();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
	}

}
